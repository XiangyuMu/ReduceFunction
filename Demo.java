import reduceExample.ElemwntList;
import reduceExample.IndexValuePair_1;
import reduceExample.TestTools;
import searchOnInternet.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException, InterruptedException {

//        Scanner scan = new Scanner(System.in);
//        System.out.println("please input the name of file: ");
//        String filename = scan.next();
//        TestTools testTools = new TestTools();
//        List<ElemwntList> list = new ArrayList<>();
//        ElemwntList elist ;
//        elist = testTools.readTestCase("TestCase/case31.txt");
//        Example31 e = new Example31();
//        System.out.println("elist: "+elist);
//        e.reduce(elist);
//        List<TwoTuple> tt1  = e.getOutput();
//        System.out.println(tt1);


        TestTools testTools = new TestTools();
//        System.out.println(testTools.isEqual("case37-10.txt"));
        ElemwntList list = testTools.readTestCase("case11.txt");
        System.out.println(list);
        Example11 example = new Example11();
        example.reduce(list);
        System.out.println(example.getOutput().toString());

    }

}
