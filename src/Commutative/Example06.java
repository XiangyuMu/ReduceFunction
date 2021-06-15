package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Example06 {

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
        long sum=0;
        int cnt=0;
        for (Element longWritable : list.getList()) {
            sum=sum+Long.parseLong(longWritable.getList().get(0).toString());
            cnt++;
        }
        long average=sum/cnt;
        output.add(new TwoTuple(key,String.valueOf(average)));
    }



}
