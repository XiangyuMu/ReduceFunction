package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Example05 {

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
        StringBuilder stb = new StringBuilder();
        HashMap<String, Integer> fileFreq = new HashMap<String, Integer>();

        for (Element val : list.getList()) {
            Integer count = fileFreq.get(val.toString());
            if (count == null) {
                count = 0;
            }
            fileFreq.put(val.toString(), count + 1);
        }
        output.add(new TwoTuple(key,String.valueOf(fileFreq)));

    }



}
