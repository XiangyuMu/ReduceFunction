package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example60 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();
    public void reduce(ElemwntList list)  {
        // sum up counts for the key
        int sum = 0;
        int count = 0;
        String sumStr = "";
        String key = (String)list.getList().get(0).getList().get(0);
        for (Element value : list.getList()) {
            count++;
            sum =sum + Integer.parseInt(value.getList().get(1).toString());

        }
        // output (word, count)
        output.add(new TwoTuple(key, sum+sumStr));
    }
}
