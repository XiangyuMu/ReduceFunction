package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example65 {
    List<TwoTuple> output = new ArrayList<TwoTuple>();
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    public void reduce(ElemwntList list){
        int sum = 0;
        String key = (String)list.getList().get(0).getList().get(0);
        // Go through all values to sum up card values for a card suit
        int count = 0;
        for (Element value : list.getList()) {

            sum =sum+ Integer.parseInt(value.getList().get(1).toString());
            count++;
        }

        output.add(new TwoTuple(key, String.valueOf(sum)));
    }
}
