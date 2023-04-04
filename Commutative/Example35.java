package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example35 {

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

        String customerName = "";
        Set<Integer> orders = new HashSet<Integer>();

        for (Element value : list.getList()) {
            if (value.getList().get(1).toString().startsWith("0")) {
                customerName = value.getList().get(1).toString().split("-")[1];
            }
            if (value.getList().get(1).toString().startsWith("1")) {
                orders.add(Integer.parseInt(value.getList().get(1).toString().split("-")[1]));
            }
        }


        output.add(new TwoTuple(key, String.valueOf(v.length())));





    }


}
