package reduceExample;

import searchOnInternet.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TestTools {
    public ElemwntList ellist = new ElemwntList();


    /**
     * 从文件中读入测试用例每个元素为Atom（名字。行，列）的形式存储
     * @param filepath
     * @return
     */
    public ElemwntList readTestCase(String filepath){

        File file = new File(filepath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            //	int count = 0;
            int row = 0;
            int column = 0;
            while ((tempString = reader.readLine()) != null) {
                String str[] = tempString.split("#");
                System.out.println("str "+str.length);
                Element el = new Element();
                for(int i = 0;i<str.length;i++) {
                    Atom atom = new Atom(str[i]);
                    atom.setColumn(row);
                    atom.setRow(column);
                    el.getAtomlist().add(atom);
                    el.getList().add(str[i]);
                    row = row + 1;
                }
                row = 0;
                column = column + 1;
                ellist.getList().add(el);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ellist;
    }



    public ElemwntList readTestCaseOneFile(BufferedReader reader) throws IOException {
        String tempString = null;
        int row = 0;
        int column = 0;
        int num = 0;
        String s = "";
        ElemwntList elemwntList = new ElemwntList();
        while ((tempString = reader.readLine()) != null){
            if (tempString.contains("$")){
                s = tempString.substring(1);
                num = Integer.parseInt(s);

                for (int k = 0; k < 10; k++) {
                    tempString = reader.readLine();
                    String str[] = tempString.split("#");
                    Element el = new Element();
                    for(int i = 0;i<str.length;i++) {
                        Atom atom = new Atom(str[i]);
                        atom.setColumn(row);
                        atom.setRow(column);
                        el.getAtomlist().add(atom);
                        el.getList().add(str[i]);
                        row = row + 1;
                    }
                    row = 0;
                    column = column + 1;
                    elemwntList.getList().add(el);
                }
                break;
            }
        }
        return elemwntList;
    }


    public boolean isEqual(String filename) throws IOException, InterruptedException {
        File file = new File(filename);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        ElemwntList init_eleList = readTestCaseOneFile(reader);
        Example11 e = new Example11();
        System.out.println(init_eleList);
        e.reduce(init_eleList);
        List<TwoTuple> tt1  = e.getOutput();
        while (true){
            ElemwntList elemwntList = readTestCaseOneFile(reader);
//            System.out.println(elemwntList);
            if (elemwntList.getList().size()!=0){
                Example11 example = new Example11();
                 example.reduce(elemwntList);
                 List<TwoTuple> tt2 = example.getOutput();
                System.out.println(tt1);
                System.out.println(tt2);
                 for (int m = 0;m<tt1.size();m++){
                     if (!tt1.get(m).equal(tt2.get(m))){

                         return false;
                     }
                 }
//                 System.out.println("qweqweq");
            }else {
                break;
            }
        }
        return true;






    }

}
