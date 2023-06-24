package TestCasesSetGeneration;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class GerenateTestCasesSet {
    public List<String> SingleTestCase_str = new ArrayList<>();
    private boolean[] used;
    private List<List<String>> res = new ArrayList<>();
    private List<List<String>> res1 = new ArrayList<>();
    private int num = 1;
    private List<Integer> relevant = new ArrayList<>();
    private List<Integer> replacement = new ArrayList<>();
    private List<Integer> irrelevant = new ArrayList<>();
    private int scale = 0;
    /**
     * 从初始测试用例中按照String读取每一行数据，为生成测试用例集做准备
     * @param filename
     * @throws IOException
     */
    public void readTestCase(String filename) throws IOException {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String keyWord = reader.readLine();
        while (keyWord!=null){
            SingleTestCase_str.add(keyWord);
            keyWord = reader.readLine();
        }
        reader.close();
    }

    public List<String> readTestCase_return(String filename) throws IOException {
        File file = new File(filename);
        List<String> stringList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String keyWord = reader.readLine();
        while (keyWord!=null){
            stringList.add(keyWord);
            keyWord = reader.readLine();
        }
        reader.close();
        return stringList;
    }

    public void generateWholeSet(String filename) throws IOException {
        File file = new File(filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        List<List<String>> list = permute(SingleTestCase_str,writer);
        System.out.println(list.size());
        writer.close();
    }

    public void readMarkList(String filename) throws IOException {
        File file = new File("src/main/java/markResult/"+filename+".txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String s1 = reader.readLine();
        String s2 = reader.readLine();
        String s3 = reader.readLine();
        if (!s1.equals("")){
            String rele[] = s1.split("#");
            for (int i = 0;i<rele.length;i++){
                relevant.add(Integer.parseInt(rele[i]));
            }
        }
        if (!s2.equals("")){
            String sub[] = s2.split("#");
            for (int i = 0;i<sub.length;i++){
                replacement.add(Integer.parseInt(sub[i]));
            }
        }
        if (!s3.equals("")){
            String irre[] = s3.split("#");
            for (int i = 0;i<irre.length;i++){
                irrelevant.add(Integer.parseInt(irre[i]));
            }
        }
    }

    public String checkPattern(){
        if (relevant.size()>0&&replacement.size()==0&&irrelevant.size()==0){
            return "StrConcat";
        }else if (relevant.size()>0&&replacement.size()>0&&irrelevant.size()>0){
            return "MaxRow";
        }else if (relevant.size()>0&&replacement.size()==0&&irrelevant.size()>0){
            if (relevant.size()==1){
                return "SingleItem";
            }else {
                for (int i = 0;i<relevant.size();i++){
                    if (!relevant.contains(i)){
                        return "IndexValuePair";
                    }
                }
                return "FirstN";
            }
        }else if (relevant.size()>0&&replacement.size()>0&&irrelevant.size()==0){
            if (relevant.size()==1){
                return "SingleItem";
            }else {
                return "IndexValuePair";
            }
        }else {
            return "Others";
        }
    }



    public int testCaseSetScale(){
        return scale;
    }

    public void generateFiveSet(String filename) throws IOException {
        File file = new File(filename);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        String pattern = "";
        pattern = checkPattern();
        switch (pattern){
            case "SingleItem":{
                if ((relevant.size()==1&&replacement.size()==0&&irrelevant.size()>0)||(relevant.size()==1&&replacement.size()>0&&irrelevant.size()==0)){
                    SingleItemTestCases(SingleTestCase_str,writer,relevant.get(0));
                }
                break;
            }

            case "IndexValuePair":{
                if((relevant.size()>1&&replacement.size()>0&&irrelevant.size()==0)||(relevant.size()>1&&replacement.size()==0&&irrelevant.size()>0)){
                    if (replacement.size()>0){
                        IndexValuePairTestCase(SingleTestCase_str,writer,relevant,replacement,2);
                    }else {
                        IndexValuePairTestCase(SingleTestCase_str,writer,relevant,irrelevant,1);
                    }
                }
                break;
            }

            case "MaxRow":{
                if (relevant.size()>0&&replacement.size()>0&&irrelevant.size()>0){
                    MaxRowTestCase(SingleTestCase_str,writer,relevant,replacement,irrelevant);
                }
                break;
            }

            case "FirstN":{

                if (relevant.size()>0&&replacement.size()==0&&irrelevant.size()>0){
                    int[] b = new int[relevant.size()];
                    FirstNTestCase(SingleTestCase_str,writer,relevant.size());
                }
                break;
            }

            case "StrConcat":{
                StrConcatTestCase(SingleTestCase_str,writer);
                break;
            }

            default:{
                otherTestCase(SingleTestCase_str,writer);
                break;
            }


        }
        writer.close();
    }

    public void printTestCase(List<String> list,BufferedWriter bufferedWriter,int i1) throws IOException {
        bufferedWriter.write("$"+i1);
        bufferedWriter.write("\n");
        for (int i = 0;i<list.size();i++){
            bufferedWriter.write(list.get(i));
            bufferedWriter.write("\n");
        }

    }
    private void SingleItemTestCases(List<String> list,BufferedWriter bufferedWriter,int selected) throws IOException {
        List<String> stringList = new ArrayList<>();
        String s = "";
        for (int i = 0;i<list.size();i++){
            for (int k = 0;k<list.size();k++){
                if (i==k){
                    stringList.add(list.get(selected));
                    continue;
                }
                if (k==selected){
                    stringList.add(list.get(i));
                    continue;
                }
                stringList.add(list.get(k));
            }
            printTestCase(stringList,bufferedWriter,i);
            scale++;
            stringList.clear();
        }
    }


    private void IndexValuePairTestCase(List<String> list,BufferedWriter bufferedWriter,List<Integer> Indexlist1,List<Integer> Indexlist2,int pattern) throws IOException {

        List<String> stringList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
//        List<String> list2_1 = new ArrayList<>();
        scale++;
        printTestCase(list,bufferedWriter,0);
        for (int i = 0;i<Indexlist1.size();i++){
            list1.add(list.get(Indexlist1.get(i)));
        }
        for (int j = 0;j<Indexlist2.size();j++){
            list2.add(list.get(Indexlist2.get(j)));

        }

        if(pattern == 1){



            for (int s = 0;s<list2.size();s++){
//                for (int t = 0;t<list2.size()-1;t++){
//                    list2_1.add(list2.get(t+1));
//                }
//                list2_1.add(list2.get(0));

                for (int k1 = 0;k1<list2.size();k1++){
                    stringList.add(list2.get(k1));
                }
                for (int k2 = 0;k2<list1.size();k2++){
                    stringList.add(list1.get(k2));
                }
                scale++;
                printTestCase(stringList,bufferedWriter,s);
                String element = list2.get(0);
                list2.remove(0);
                list2.add(element);
                stringList.clear();

            }

        }else if (pattern == 2){

            for (int s = 0;s<list2.size();s++){
//                for (int t = 0;t<list2.size()-1;t++){
//                    list2_1.add(list2.get(t+1));
//                }
//                list2_1.add(list2.get(0));

                for (int k2 = 0;k2<list1.size();k2++){
                    stringList.add(list1.get(k2));
                }
                for (int k1 = 0;k1<list2.size();k1++){
                    stringList.add(list2.get(k1));
                }

                scale++;
                printTestCase(stringList,bufferedWriter,s);
                String element = list2.get(0);
                list2.remove(0);
                list2.add(element);
                stringList.clear();

            }
        }






    }



    private void MaxRowTestCase(List<String> list,BufferedWriter bufferedWriter,List<Integer> relativeList,List<Integer> replaceList,List<Integer> irrelativeList) throws IOException {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        for (int i = 0;i<relativeList.size();i++){
            list1.add(list.get(relativeList.get(i)));
        }
        for (int k = 0;k < replaceList.size();k++){
            list2.add(list.get(replaceList.get(k)));
        }
        for (int j = 0;j < irrelativeList.size();j++){
            list3.add(list.get(irrelativeList.get(j)));
        }
        printTestCase(list,bufferedWriter,0);

        if (list2.size()>list3.size()){
            for (int i = 0;i<list2.size();i++){
                if (i<list3.size()){
                    String s = list3.get(0);
                    list3.remove(0);
                    list3.add(s);
                }


                String s1 = list2.get(0);
                list2.remove(0);
                list2.add(s1);

                for (int j0 = 0;j0<list3.size();j0++){
                    stringList.add(list3.get(j0));
                }
                for (int j1 = 0;j1<list1.size();j1++){
                    stringList.add(list1.get(j1));
                }
                for (int j2 = 0;j2<list2.size();j2++){
                    stringList.add(list2.get(j2));
                }
                scale++;
                printTestCase(stringList,bufferedWriter,i+1);
                stringList.clear();
            }
        }else {
            for (int i = 0;i<list3.size();i++){
                if (i<list2.size()){
                    String s = list2.get(0);
                    list2.remove(0);
                    list2.add(s);
                }


                String s1 = list3.get(0);
                list3.remove(0);
                list3.add(s1);

                for (int j0 = 0;j0<list3.size();j0++){
                    stringList.add(list3.get(j0));
                }
                for (int j1 = 0;j1<list1.size();j1++){
                    stringList.add(list1.get(j1));
                }
                for (int j2 = 0;j2<list2.size();j2++){
                    stringList.add(list2.get(j2));
                }
                scale++;
                printTestCase(stringList,bufferedWriter,i+1);
                stringList.clear();
            }
        }
    }


    private void FirstNTestCase(List<String> list,BufferedWriter bufferedWriter,int N) throws IOException {
        System.out.println("N: "+N);
        int totalNum = list.size();
        List<String> stringList = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        printTestCase(list,bufferedWriter,0);
        scale++;
        for (int i = 0;i<N;i++){
            list1.add(list.get(i));
        }
        for (int k = N;k < list.size();k++){
            list2.add(list.get(k));
        }

        if (N>totalNum-N){
            for (int j = 0;j<(2*N-totalNum+1);j++){
                for (int j1 = 0;j1<j;j1++){
                    stringList.add(list1.get(j1));
                }
                for (int j2 = 0;j2<list2.size();j2++){
                    stringList.add(list2.get(j2));
                }
                for (int j3 = j;j3<list1.size();j3++){
                    stringList.add(list1.get(j3));
                }

                scale++;
                printTestCase(stringList,bufferedWriter,j);
                stringList.clear();

            }
        }else if (N<totalNum-N){

            for (int j = 0;j<totalNum-2*N+1;j++) {
                for (int j1 = j; j1 < N+j; j1++) {
                 //   System.out.println(j1);
                    stringList.add(list2.get(j1));
                }
                for (int j2 = 0;j2<j;j2++){
                    stringList.add(list2.get(j2));
                }
                for (int j2 = 0; j2 < list1.size(); j2++) {
                    stringList.add(list1.get(j2));
                }
                for (int j3 = j+N; j3 < list2.size(); j3++) {
                    stringList.add(list2.get(j3));
                }

                scale++;
                printTestCase(stringList, bufferedWriter, j);
                stringList.clear();
            }
        }else if (N==totalNum-N){
            System.out.println("yun");
            for (int j = 0;j<list2.size();j++){
                stringList.add(list2.get(j));
            }
            for (int k = 0;k<list1.size();k++){
                stringList.add(list1.get(k));
            }
            scale++;
            printTestCase(stringList, bufferedWriter, 0);
            stringList.clear();
        }


    }

    private void StrConcatTestCase(List<String> list,BufferedWriter bufferedWriter) throws IOException {
        List<String> stringList = new ArrayList<>();
        for (int i = 0;i<list.size()-1;i++){
            stringList.add(list.get(i+1));
        }
        stringList.add(list.get(0));
        scale++;
        printTestCase(stringList,bufferedWriter,0);
        stringList.clear();
        for (int i = 0;i<list.size();i++){
            stringList.add(list.get(i));
        }
        scale++;
        printTestCase(stringList,bufferedWriter,1);
        stringList.clear();
    }

    private void otherTestCase(List<String> list,BufferedWriter bufferedWriter) throws IOException {
        List<String> stringList = new ArrayList<>();
        for (int i = 0;i<list.size();i++){
            for (int j = i;j<list.size();j++){
                stringList.add(list.get(j));
            }
            for (int k = 0;k<i;k++){
                stringList.add(list.get(k));
            }
            scale++;
            printTestCase(stringList,bufferedWriter,i);
            stringList.clear();
        }
    }

    public void RandomTestCases(int num, BufferedReader reader,BufferedWriter bufferedWriter) throws IOException {
        List<String> stringList = new ArrayList<>();
        int a[] = new int[num];
        Random random = new Random();
        for (int i = 0;i < num;i++){
            a[i] = random.nextInt(3628800);
//            System.out.println(a[i]);
        }
        Arrays.sort(a);
        for (int j = 0;j<num;j++){
            stringList = readTestCase1(a[j],reader);
            printTestCase(stringList,bufferedWriter,a[j]);
            stringList.clear();
        }
        bufferedWriter.close();
    }

    public void RandomTestCases_Single(int num, BufferedReader reader,BufferedWriter bufferedWriter) throws IOException {
        List<String> stringList_1 = new ArrayList<>();
        stringList_1 = readTestCase_return("H:\\ReduceTest\\src\\main\\java\\TestCase\\case6.txt");
        List<String> stringList_2 = new ArrayList<>();
        int a[] = new int[2];
        Random random = new Random();
        for (int i = 0;i < num;i++){
            a[0] = random.nextInt(10);
            a[1] = random.nextInt(10);
            if (a[0]==a[1]){
                a[1] = random.nextInt(10);
            }
            System.out.println(a[0]);
            System.out.println(a[1]);
            System.out.println();
            for (int j = 0;j<stringList_1.size();j++){
                if (a[0]==j){
                    stringList_2.add(stringList_1.get(a[1]));
                }else if (a[1]==j){
                    stringList_2.add(stringList_1.get(a[0]));
                }else {
                    stringList_2.add(stringList_1.get(j));
                }
            }
            printTestCase(stringList_2,bufferedWriter,i+1);
            stringList_1.clear();
            for (int k = 0;k<stringList_2.size();k++){
                stringList_1.add(stringList_2.get(k));
            }
            stringList_2.clear();

        }

        bufferedWriter.close();
    }



    public List<String> readTestCase1(int num, BufferedReader reader) throws IOException {
        int n;
        String s = "";
        List<String> SingleTestCase_str = new ArrayList<>();
        String keyWord = reader.readLine();
        while (keyWord != null) {
            if (keyWord.contains("$")) {
                s = keyWord.substring(1);
                n = Integer.parseInt(s);
                //System.out.println(n);
                if (n == num) {
                    for (int i = 0; i < 10; i++) {

                        SingleTestCase_str.add(reader.readLine());
                    }
                    break;
                }else {
                    keyWord =  reader.readLine();
                }
            }else {
                keyWord = reader.readLine();
            }
        }
        return SingleTestCase_str;
    }


    public List<List<String>> permute(List<String> nums,BufferedWriter bufferedWriter) throws IOException {
        if (nums.size() == 0) {
            return res;
        }

        used = new boolean[nums.size()];
        List<String> preList = new ArrayList<>();
        generatePermutation(nums, 0, preList,bufferedWriter);

        return res;

    }




    /**
     * 回溯
     * @param nums 给定数组
     * @param index 当前考察的索引位置
     * @param preList 先前排列好的子序列
     */
    private void generatePermutation(List<String> nums,int index,List<String> preList,BufferedWriter bufferedWriter) throws IOException {
        //index 等于给定数组的长度时，说明一种排列已经形成，直接将其加入成员变量 res 里
        if (index == nums.size()) {
            //这里需要注意java的值传递
            //此处必须使用重新创建对象的形式，否则 res 列表中存放的都是同一个引用
            bufferedWriter.write("$"+num);
            num++;
            bufferedWriter.write("\n");
            for (int i = 0;i<preList.size();i++){
                bufferedWriter.write(preList.get(i));
                bufferedWriter.write("\n");
            }
//            if (flag){
//                res.add(new ArrayList<>(preList));
//                flag = false;
//            }else {
//                res1.add(new ArrayList<>(preList));
//                flag = true;
//            }
//            System.out.println(res.size());
            //System.out.println(num);
            return;
        }

        for(int i = 0; i < nums.size() ;i++) {
            if (!used[i]) {
                preList.add(nums.get(i));
                used[i] = true;
                generatePermutation(nums, index + 1, preList,bufferedWriter);
                //一定要记得回溯状态
                preList.remove(preList.size() - 1);
                used[i] = false;
            }
        }
        return;
    }




    public int[] combine( int a[], int n, int m,  int b[],  int M )
    {
        int[] d = new int[M];
        for(int i=n; i>=m; i--)   // 注意这里的循环范围
        {
            b[m-1] = i - 1;
            if (m > 1)
                combine(a,i-1,m-1,b,M);

        }
        return b;
    }

}
