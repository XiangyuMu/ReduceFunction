package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Example03 {

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
        int counter = 0;
        for (Element v: list.getList()) {
            counter += Integer.parseInt(v.getList().get(0).toString());
        }
        System.out.println(key.toString());
        if (counter > 1)
            output.add(new TwoTuple(key,String.valueOf(counter)));

    }



}
