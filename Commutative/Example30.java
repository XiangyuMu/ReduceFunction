package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example30 {

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
        long upFlow = 0;
        long dFlow = 0;
        for (Element value : list.getList()) {
            upFlow += Integer.parseInt(value.getList().get(1).toString());
            dFlow += Integer.parseInt(value.getList().get(2).toString());
        }
        v = upFlow+" "+dFlow;

        output.add(new TwoTuple(key, String.valueOf(v)));
    }


}
