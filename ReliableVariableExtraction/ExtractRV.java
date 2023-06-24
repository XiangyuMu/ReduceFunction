package ReliableVariableExtraction;

import BytemanProgram.CreateBTMFile;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.ForEachStmt;
import com.github.javaparser.ast.stmt.ForStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExtractRV {

    public static String filepath  = "";



    private static class ExpressVisitor_1 extends VoidVisitorAdapter<MixStructure>{


        public String filename = "";
        public File file;
        BufferedWriter bufferedWriter ;

        @Override
        public void visit(ForStmt n, MixStructure arg) {
            super.visit(n, arg);
            System.out.println("ForStmt:"+n);
        }

        @Override
        public void visit(ClassOrInterfaceDeclaration n, MixStructure   arg) {
            super.visit(n, arg);
            filename = n.getNameAsString();
            file = new File(filename);
            try {
                bufferedWriter = new BufferedWriter(new FileWriter(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void visit(ForEachStmt n, MixStructure arg) {
            super.visit(n, arg);
            System.out.println("ForEachStmt:"+n.getIterable());
            if (hasKeyWord(n.getIterable(),arg.getKeyWord())){


                if (!arg.getKeyWord().contains(n.getVariable().getVariable(0).getName().toString().trim())){
                    arg.getKeyWord().add(n.getVariable().getVariable(0).getName().toString().trim());
                }



            }

        }

        @Override
        public void visit(AssignExpr n, MixStructure arg) {
            super.visit(n, arg);
            System.out.println("AssignStmt:"+n);
            System.out.println("AssignTargetType: "+n.getTarget().getMetaModel());
            if (hasKeyWord(n.getValue(),arg.getKeyWord())){

                if (!arg.getKeyWord().contains(getSingleKeyWord(n.getTarget()))){
                    arg.getKeyWord().add(getSingleKeyWord(n.getTarget()));
                }



                List<String> kl = getMultiKeyWords(n.getValue());
                String T = getSingleKeyWord(n.getTarget());
                AssignStatement assignStatement = new AssignStatement();
                assignStatement.setTarget(T);
                assignStatement.setLine(n.getBegin().get().line);
                assignStatement.setType("Assign");
                assignStatement.setFilename(filename);
                List<String> ls = new ArrayList<>();
                if (kl.size()>1){
                    for (int i = 0;i<kl.size();i++){
                        if (arg.getKeyWord().contains(kl.get(i))){
                            ls.add(kl.get(i));
                        }
                    }
                    if (ls.size()>1){
                        assignStatement.setValue1(ls.get(0));
                        assignStatement.setValue2(ls.get(1));
                    }else {
                        assignStatement.setValue1(ls.get(0));
                        assignStatement.setValue2(T);
                    }
                }else {
                    assignStatement.setValue1(kl.get(0));
                }
                arg.getStatements().add(assignStatement);

            }
        }

        @Override
        public void visit(VariableDeclarationExpr n, MixStructure arg) {
            super.visit(n, arg);
            System.out.println("VariableDeclarationExpr: "+n.getVariable(0).getInitializer());
            if (n.getVariable(0).getInitializer().toString()!="Optional.empty"){
                Expression expression = n.getVariable(0).getInitializer().get();
                if (hasKeyWord(expression,arg.getKeyWord())){

                    if (!arg.getKeyWord().contains(getSingleKeyWord(n.getVariable(0).getNameAsExpression()))){
                        arg.getKeyWord().add(getSingleKeyWord(n.getVariable(0).getNameAsExpression()));
                    }
                    List<String> kl = getMultiKeyWords(expression);
                    String T = getSingleKeyWord(n.getVariable(0).getNameAsExpression());
                    AssignStatement assignStatement = new AssignStatement();
                    assignStatement.setTarget(T);
                    assignStatement.setLine(n.getBegin().get().line);
                    assignStatement.setType("Assign");
                    assignStatement.setFilename(filename);
                    List<String> ls = new ArrayList<>();
                    System.out.println("kl:"+kl);
                    if (kl.size()>1){
                        for (int i = 0;i<kl.size();i++){
                            if (arg.getKeyWord().contains(kl.get(i))){
                                ls.add(kl.get(i));
                            }
                        }
                        if (ls.size()>1){
                            assignStatement.setValue1(ls.get(0));
                            assignStatement.setValue2(ls.get(1));
                        }else {
                            assignStatement.setValue1(ls.get(0));
                            assignStatement.setValue2(T);
                        }
                    }else {
                        assignStatement.setValue1(kl.get(0));
                    }
                    arg.getStatements().add(assignStatement);

                }
            }
        }

        @Override
        public void visit(MethodCallExpr n, MixStructure arg) {
            super.visit(n, arg);
            System.out.println("MethodCallExpr: "+n.getScope().get());
            System.out.println("scope: "+getMethodScope(n));
            for (int i = 0;i<n.getArguments().size();i++){
                System.out.println("Argument: "+hasKeyWord(n.getArguments().get(i),arg.getKeyWord()));
                if (hasKeyWord(n.getArguments().get(i),arg.getKeyWord())){
                    if (!arg.getKeyWord().contains(getMethodScope(n).trim())&&getMethodScope(n)!=""){
                        if(!(getMethodScope(n).equals("Float")||getMethodScope(n).equals("Integer")||getMethodScope(n).equals("String")||getMethodScope(n).equals("Char")||getMethodScope(n).equals("Boolean")||getMethodScope(n).equals("System.out")||getMethodScope(n).equals("Double")))
                            arg.getKeyWord().add(getMethodScope(n).trim());
                        SimpleName e = new SimpleName();

                    }
                }
            }
        }


        public String getSingleKeyWord(Expression e){

                Stack<Node> stack = new Stack<>();
                for(int i = 0;i<e.getChildNodes().size();i++){
                    stack.add(e.getChildNodes().get(i));
                }
                while(!stack.isEmpty()){
                    Node node = stack.pop();
                    if(node.getChildNodes().size()==0){
                        if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                            if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                                System.out.println("Stack: "+node.toString());
                                return node.toString();
                            }

                        }
                    }else{
                        for(int j = 0;j<node.getChildNodes().size();j++){
                            stack.add(node.getChildNodes().get(j));
                        }
                    }
                }
                return "ERROR!";

        }


        public List<String> getMultiKeyWords(Expression e){
            List<String> keyWord = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            for(int i = 0;i<e.getChildNodes().size();i++){
                stack.add(e.getChildNodes().get(i));
            }
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.getChildNodes().size()==0){
                    if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                        if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                            System.out.println("Stack: "+node.toString());
                            keyWord.add(node.toString());
                        }

                    }
                }else{
                    for(int j = 0;j<node.getChildNodes().size();j++){
                        stack.add(node.getChildNodes().get(j));
                    }
                }
            }
            return keyWord;
        }



        public boolean hasKeyWord(Expression e,List<String> keyWordList){
            Stack<Node> stack = new Stack<>();
            for(int i = 0;i<e.getChildNodes().size();i++){
                stack.add(e.getChildNodes().get(i));
            }
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.getChildNodes().size()==0){
                    if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                        if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                            System.out.println("Stack: "+node.toString());
                            System.out.println("keyWordList: "+keyWordList);
                            for (String k : keyWordList){
                                if (k.equals(node.toString().trim())){
                                    return true;
                                }
                            }
                        }

                    }
                }else{
                    for(int j = 0;j<node.getChildNodes().size();j++){
                        stack.add(node.getChildNodes().get(j));
                    }
                }
            }
            return false;
        }
    }

    private static class ExpressVisitor_2 extends VoidVisitorAdapter<MixType>{
        @Override
        public void visit(VariableDeclarator n, MixType arg) {
            super.visit(n, arg);
            for (int i = 0;i<arg.getKeyWord().size();i++){
                if (arg.getKeyWord().get(i).getName().equals(n.getNameAsString())){
                    arg.getKeyWord().get(i).setType(n.getType().toString());
                }
            }

        }
    }


    private static class ExpressVisitor_3 extends VoidVisitorAdapter<MixType>{
        @Override
        public void visit(ForEachStmt n, MixType arg) {
            super.visit(n, arg);
            System.out.println("ForEachStmt:"+n.getIterable());

            if (isInKeyWord(n.getIterable(),arg.getKeyWord())){
                ForEachStatement forEachStatement = new ForEachStatement();
                forEachStatement.setFilename("filename");
                forEachStatement.setType("forEach");
                forEachStatement.setVariable(n.getVariable().getVariable(0).getNameAsString().trim());
                forEachStatement.setLine(n.getBegin().get().line);
             //   forEachStatement.setIterable(getMethodScope((MethodCallExpr) n.getIterable()));

                if (n.getIterable().getMetaModel().toString().equals("MethodCallExpr")){
                    forEachStatement.setIterable(getMethodScope((MethodCallExpr) n.getIterable()));
                }else {
                    forEachStatement.setIterable(getSingleKeyWord(n.getIterable()));
                }

                boolean flag = true;
                for (int i = 0;i<arg.getStatements().size();i++){
                    if (arg.getStatements().get(i).equals(forEachStatement)){
                        flag = false;
                        break;
                    }
                }
                if (flag!=false){
                    arg.getStatements().add(forEachStatement);
                }


            }

        }

        public void visit(AssignExpr n, MixType arg) {
            super.visit(n, arg);
            System.out.println("AssignStmt:"+n);
            System.out.println("AssignTargetType: "+n.getTarget().getMetaModel());
            if (isInKeyWord(n.getValue(),arg.getKeyWord())){

                List<String> kl = getMultiKeyWords(n.getValue());
                String T = getSingleKeyWord(n.getTarget());
                AssignStatement assignStatement = new AssignStatement();
                assignStatement.setTarget(T);
                assignStatement.setLine(n.getBegin().get().line);
                assignStatement.setType("Assign");
                assignStatement.setFilename("filename");
                List<String> ls = new ArrayList<>();
//                if (kl.size()>1){
                    for (int i = 0;i<kl.size();i++){
                        for (KeyWord k:arg.getKeyWord()){
                            if (k.getName().equals(kl.get(i))){
                                ls.add(kl.get(i));
                            }
                        }
                    }
                    if (ls.size()>1){
                        assignStatement.setValue1(ls.get(0));
                        assignStatement.setValue2(ls.get(1));
                    }else {
                        assignStatement.setValue1(ls.get(0));

                    }
//                }
                boolean flag = true;
                for (int i = 0;i<arg.getStatements().size();i++){
                    if (arg.getStatements().get(i).equals(assignStatement)){
                        flag = false;
                        break;
                    }
                }
                if (flag!=false){
                    arg.getStatements().add(assignStatement);
                }

            }
        }


        @Override
        public void visit(VariableDeclarationExpr n, MixType arg) {
            super.visit(n, arg);
            System.out.println("VariableDeclarationExpr: " + n.getVariable(0).getInitializer());
            if (n.getVariable(0).getInitializer().toString() != "Optional.empty") {
                Expression expression = n.getVariable(0).getInitializer().get();
                if (isInKeyWord(expression, arg.getKeyWord())) {

                    List<String> kl = getMultiKeyWords(expression);
                    String T = getSingleKeyWord(n.getVariable(0).getNameAsExpression());
                    AssignStatement assignStatement = new AssignStatement();
                    assignStatement.setTarget(T);
                    assignStatement.setLine(n.getBegin().get().line);
                    assignStatement.setType("Assign");
                    assignStatement.setFilename("filename");
                    List<String> ls = new ArrayList<>();
                    System.out.println("kl:" + kl);
                    if (kl.size() > 1) {
                        for (int i = 0; i < kl.size(); i++) {
                            for (KeyWord k : arg.getKeyWord()) {
                                if (k.getName().equals(kl.get(i))) {
                                    ls.add(kl.get(i));
                                }
                            }
                        }
                        if (ls.size() > 1) {
                            assignStatement.setValue1(ls.get(0));
                            assignStatement.setValue2(ls.get(1));
                        } else {
                            assignStatement.setValue1(ls.get(0));

                        }
//                }
                        boolean flag = true;
                        for (int i = 0; i < arg.getStatements().size(); i++) {
                            if (arg.getStatements().get(i).equals(assignStatement)) {
                                flag = false;
                                break;
                            }
                        }
                        if (flag != false) {
                            arg.getStatements().add(assignStatement);
                        }

                    }
                }
            }


        }


        @Override
        public void visit(MethodCallExpr n, MixType arg) {
            super.visit(n, arg);
            System.out.println("MethodCallExpr: "+n.getScope().get());
            System.out.println("scope: "+getMethodScope(n));
            if (getMethodScope(n).equals("output")&&n.getArguments().get(0).getMetaModel().toString().equals("ObjectCreationExpr")){
                ObjectCreationExpr octe = (ObjectCreationExpr) n.getArguments().get(0);
                MethodStatement methodStatement1 = new MethodStatement();
                MethodStatement methodStatement2 = new MethodStatement();
                methodStatement1.setFilename("filename");
                methodStatement2.setFilename("filename");
                methodStatement1.setLine(n.getBegin().get().line);
                methodStatement2.setLine(n.getBegin().get().line);
                methodStatement1.setType("List");
                methodStatement2.setType("List");
                methodStatement1.setVariable("output");
                methodStatement2.setVariable("output");
                if (octe.getArguments().get(0).getMetaModel().toString().equals("MethodCallExpr")){
                    if (isInKeyWord(octe.getArguments().get(0),arg.keyWord)){
                        methodStatement1.getAssignList().add(getMethodScope((MethodCallExpr) octe.getArguments().get(0)));
                    }

                }else {
                    if (isInKeyWord(octe.getArguments().get(0),arg.keyWord)){
                        methodStatement1.getAssignList().add(getSingleKeyWord(octe.getArguments().get(0)));
                    }
                }
                if (octe.getArguments().get(1).getMetaModel().toString().equals("MethodCallExpr")){

                    if (isInKeyWord(octe.getArguments().get(1),arg.keyWord)){
                        methodStatement2.getAssignList().add(getMethodScope((MethodCallExpr) octe.getArguments().get(1)));
                    }

                }else {
                    if (isInKeyWord(octe.getArguments().get(1),arg.keyWord)){
                        methodStatement2.getAssignList().add(getSingleKeyWord(octe.getArguments().get(1)));
                    }
                }
                if (methodStatement1.getAssignList().size()!=0){
                    arg.getStatements().add(methodStatement1);
                }
                if (methodStatement2.getAssignList().size()!=0){
                    arg.getStatements().add(methodStatement2);
                }

            }else {
                for (int i = 0;i<n.getArguments().size();i++){
                    System.out.println("Argument: "+isInKeyWord(n.getArguments().get(i),arg.getKeyWord()));
                    MethodStatement methodStatement = new MethodStatement();
                    if (isInKeyWord(n.getArguments().get(i),arg.getKeyWord())){
                        for (int j = 0;j<arg.getKeyWord().size();j++){
                            if (getMethodScope(n).equals(arg.getKeyWord().get(j).getName())){
                                if (methodStatement.getLine()==n.getBegin().get().line){
                                    methodStatement.getAssignList().add(getWord(n.getArguments().get(i),arg.getKeyWord()));
                                }else {
                                    methodStatement.setVariable(getMethodScope(n));
                                    methodStatement.setType(arg.getKeyWord().get(j).getType());
                                    methodStatement.setLine(n.getBegin().get().line);
                                    methodStatement.setFilename("Filename");
                                    methodStatement.getAssignList().add(getWord(n.getArguments().get(i),arg.getKeyWord()));
                                }

                            }

                        }

                    }
                    if (methodStatement.getLine()==n.getBegin().get().line){
                        boolean flag = true;
                        for (int k = 0;k<arg.getStatements().size();k++){
                            if (arg.getStatements().get(k).equals(methodStatement)){
                                flag = false;
                                break;
                            }
                        }
                        if (flag!=false){
                            arg.getStatements().add(methodStatement);
                        }
                    }
                }
            }





        }

        public boolean isInKeyWord(Expression e, List<KeyWord> keyWordList){
            Stack<Node> stack = new Stack<>();
            for(int i = 0;i<e.getChildNodes().size();i++){
                stack.add(e.getChildNodes().get(i));
            }
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.getChildNodes().size()==0){
                    if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                        if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                            System.out.println("Stack: "+node.toString());
                            System.out.println("keyWordList: "+keyWordList);
                            for (KeyWord k : keyWordList){
                                if (k.getName().equals(node.toString().trim())){
                                    return true;
                                }
                            }
                        }

                    }
                }else{
                    for(int j = 0;j<node.getChildNodes().size();j++){
                        stack.add(node.getChildNodes().get(j));
                    }
                }
            }
            return false;
        }

        public String getWord(Expression e, List<KeyWord> keyWordList){
            Stack<Node> stack = new Stack<>();
            for(int i = 0;i<e.getChildNodes().size();i++){
                stack.add(e.getChildNodes().get(i));
            }
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.getChildNodes().size()==0){
                    if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                        if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                            System.out.println("Stack: "+node.toString());
                            System.out.println("keyWordList: "+keyWordList);
                            for (KeyWord k : keyWordList){
                                if (k.getName().equals(node.toString().trim())){
                                    return node.toString().trim();
                                }
                            }
                        }

                    }
                }else{
                    for(int j = 0;j<node.getChildNodes().size();j++){
                        stack.add(node.getChildNodes().get(j));
                    }
                }
            }
            return null;
        }



        public String getSingleKeyWord(Expression e){

            Stack<Node> stack = new Stack<>();
            for(int i = 0;i<e.getChildNodes().size();i++){
                stack.add(e.getChildNodes().get(i));
            }
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.getChildNodes().size()==0){
                    if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                        if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                            System.out.println("Stack: "+node.toString());
                            return node.toString();
                        }

                    }
                }else{
                    for(int j = 0;j<node.getChildNodes().size();j++){
                        stack.add(node.getChildNodes().get(j));
                    }
                }
            }
            return "ERROR!";

        }


        public List<String> getMultiKeyWords(Expression e){
            List<String> keyWord = new ArrayList<>();
            Stack<Node> stack = new Stack<>();
            for(int i = 0;i<e.getChildNodes().size();i++){
                stack.add(e.getChildNodes().get(i));
            }
            while(!stack.isEmpty()){
                Node node = stack.pop();
                if(node.getChildNodes().size()==0){
                    if(node.getMetaModel().toString().equals("NameExpr")||node.getMetaModel().toString().equals("SimpleName")){
                        if(!(node.toString().equals("Float")||node.toString().equals("Integer")||node.toString().equals("String")||node.toString().equals("Char")||node.toString().equals("Boolean")||node.toString().equals("System.out"))){
                            System.out.println("Stack: "+node.toString());
                            keyWord.add(node.toString());
                        }

                    }
                }else{
                    for(int j = 0;j<node.getChildNodes().size();j++){
                        stack.add(node.getChildNodes().get(j));
                    }
                }
            }
            return keyWord;
        }

    }



    public static String getMethodScope(MethodCallExpr n){
        if (n.getScope().get().isMethodCallExpr()){
            return getMethodScope(n.getScope().get().asMethodCallExpr());
        }
        else if (n.getScope().get().isNameExpr()){
            return n.getScope().get().toString();
        }
        else {
            return "";
        }
    }


    public void printToFile(String filename,List<String> list) throws IOException {
        File file = new File("src/main/java/keyWord/"+filename+".txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (String keyWord : list){
            writer.write(keyWord);
            writer.write("\n");
        }
        writer.close();
    }


    public List<String> readFromFile(String filename) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File("keyWord/"+filename+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String keyWord = reader.readLine();
        while (keyWord!=null){
            list.add(keyWord);
            keyWord = reader.readLine();
        }
        return list;
    }


    public void Extract(String filename) throws IOException {

        filepath = "src/main/java/searchOnInternet/"+filename+".java";
        CompilationUnit cu = StaticJavaParser.parse(new File(filepath));

        MixStructure ms = new MixStructure();

        ms.getKeyWord().add("list");
        cu.accept(new ExpressVisitor_1(),ms);
        int formerMs = 0;
        while(ms.getKeyWord().size()!=formerMs){
            formerMs = ms.getKeyWord().size();
            cu.accept(new ExpressVisitor_1(),ms);
        }
        MixType mixType = new MixType();
        for (String s:ms.getKeyWord()){
            mixType.getKeyWord().add(new KeyWord(s));
        }
        cu.accept(new ExpressVisitor_2(),mixType);
        cu.accept(new ExpressVisitor_3(),mixType);
        ExtractRV extractRV = new ExtractRV();
        extractRV.printToFile(filename,ms.getKeyWord());
//        System.out.println("ms: "+ms);
        for (int i = 0;i<mixType.getStatements().size();i++){
            mixType.getStatements().get(i).setFilename(filename);
        }
        System.out.println("mt: "+mixType);
        CreateBTMFile createBTMFile = new CreateBTMFile();
        System.out.println(createBTMFile.generateBTM(mixType));
        File file = new File("src/main/java/BytemanProgram/"+filename+"fina.btm");
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write(createBTMFile.generateBTM(mixType));
        bufferedWriter.close();
    }

    public static void main(String[] args) throws IOException {

        String filename = "Example26";
        ExtractRV extractRV = new ExtractRV();
        extractRV.Extract(filename);
    }
}
