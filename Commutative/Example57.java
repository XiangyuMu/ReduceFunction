package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example57 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    int N = 8;
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    public void reduce(ElemwntList list) {
        ElemwntList elelist = new ElemwntList();
        String key = (String)list.getList().get(0).getList().get(0);
        int count = 0;
        for(Element el : list.getList()) {
            count++;
            elelist.getList().add(el);
        }
        output.add(new TwoTuple(key, elelist.toString()));
    }


}
