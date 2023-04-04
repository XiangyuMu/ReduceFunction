package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Example08 {

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
        int cnt = 0;
        Iterator<Element> values = list.getList().listIterator();
        while (values.hasNext()) {
            cnt = cnt + Integer.parseInt(values.next().getList().get(0).toString());
        }
        output.add(new TwoTuple(String.valueOf(cnt),String.valueOf(cnt)));
    }



}
