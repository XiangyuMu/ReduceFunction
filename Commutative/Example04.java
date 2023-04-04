package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example04 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v = "";
    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        String outputValue;
        double arr[] = new double[2];
        int count = 0;
        for (Element line : list.getList()){
            String[] str1 = line.getList().get(0).toString().split(":");

            if (str1.length == 2) {
                count += Integer.parseInt(str1[1]);
            }
            String[] str = str1[0].split(",");
            for (int i = 0; i < 2; i++) {
                arr[i] += Double.parseDouble(str[i]);
            }
            count++;
        }
        outputValue = arr.toString() + ":" + String.valueOf(count);

        output.add(new TwoTuple(key,String.valueOf(outputValue)));

    }



}
