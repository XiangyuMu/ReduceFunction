package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example13 {

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
        int sum = 0;
        Iterator<Element> iter = list.getList().iterator();
        while (iter.hasNext()) {
            sum += Integer.parseInt(iter.next().getList().get(1).toString());
        }
        output.add(new TwoTuple(String.valueOf(key),String.valueOf(sum)));

    }



}
