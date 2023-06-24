import TestCasesSetGeneration.GerenateTestCasesSet;

import java.io.*;
import java.util.Scanner;

public class Demo1 {


    public static void main(String[] args) throws IOException {
        GerenateTestCasesSet gerenateTestCasesSet = new GerenateTestCasesSet();
        System.out.println("please input the name of file: ");
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        gerenateTestCasesSet.readTestCase("case"+num+".txt");                   //here
        System.out.println(gerenateTestCasesSet.SingleTestCase_str);
        gerenateTestCasesSet.readMarkList("Example"+num+"");                   //here
        System.out.println(gerenateTestCasesSet.checkPattern());
        gerenateTestCasesSet.generateFiveSet("case"+num+"we.txt");             //here
        gerenateTestCasesSet.generateWholeSet("case"+num+"_Whole.txt");        //here
        File fileread = new File("case"+num+"_Whole.txt");                     //here
        File filewrite = new File("case"+num+"_n.txt");                         //here
        BufferedReader reader = new BufferedReader(new FileReader(fileread));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filewrite));
        System.out.println("all:"+gerenateTestCasesSet.testCaseSetScale());
        gerenateTestCasesSet.RandomTestCases(gerenateTestCasesSet.testCaseSetScale(), reader, writer);                //here
        File filewrite2 = new File("case"+num+"_2n.txt");                         //here
        BufferedWriter writer2 = new BufferedWriter(new FileWriter(filewrite2));
        BufferedReader reader2 = new BufferedReader(new FileReader(fileread));
        gerenateTestCasesSet.RandomTestCases(2*gerenateTestCasesSet.testCaseSetScale(), reader2, writer2);
        File filewrite3 = new File("case"+num+"_3n.txt");                         //here
        BufferedWriter writer3 = new BufferedWriter(new FileWriter(filewrite3));
        BufferedReader reader3 = new BufferedReader(new FileReader(fileread));
        gerenateTestCasesSet.RandomTestCases(3*gerenateTestCasesSet.testCaseSetScale(), reader3, writer3);
    }


}
