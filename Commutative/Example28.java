package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example28 {

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
        long sum = 0;

        for (Element line : list.getList()) {
            String[] fields = line.getList().get(1).toString().split("\\\\");

            if (fields[2].length() > 0) {
                sum++;
            }
        }

        output.add(new TwoTuple(key, String.valueOf(sum)));
    }


}
