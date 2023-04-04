package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example33 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;

    public void reduce(ElemwntList values) {
        String key = (String)values.getList().get(0).getList().get(0);
        int sum = 0;
        for (Element val : values.getList()) {
            sum += Integer.parseInt(val.getList().get(1).toString());
        }

        output.add(new TwoTuple(key, String.valueOf(sum)));
    }


}
