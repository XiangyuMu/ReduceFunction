import reduceExample.ElemwntList;
import reduceExample.TestTools;
import searchOnInternet.Example01;
import searchOnInternet.Example11;
import searchOnInternet.TwoTuple;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scan = new Scanner(System.in);
        System.out.println("please input the name of file: ");
        String filename = scan.next();
        TestTools testTools = new TestTools();
//        List<ElemwntList> list = new ArrayList<>();
//        ElemwntList elist ;
//        elist = testTools.readTestCase("src/main/java/TestCase/case"+filename+".txt");
//        Example01 e = new Example01();
//        System.out.println("elist: "+elist);
//        e.reduce(elist);
//        List<TwoTuple> tt1  = e.getOutput();
//        System.out.println(tt1);02
        System.out.println(testTools.isEqual("case"+filename+"we.txt"));
        System.out.println(testTools.isEqual("case"+filename+"_n.txt"));
        System.out.println(testTools.isEqual("case"+filename+"_2n.txt"));
        System.out.println(testTools.isEqual("case"+filename+"_3n.txt"));
//        ElemwntList list = testTools.readTestCase("case11.txt");
//        System.out.println(list);
//        Example11 example11 = new Example11();
//        example11.reduce(list);
//
//        System.out.println(example11.getOutput().toString());


    }
}
