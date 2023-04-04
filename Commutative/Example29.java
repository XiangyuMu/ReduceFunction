package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example29 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v = "";


    public void reduce(ElemwntList list) {
        Map<String, Integer> map = null;
        map = new HashMap<String, Integer>();
        String key = (String)list.getList().get(0).getList().get(0);
        int sum = 0;
        for (Element value : list.getList()) {
            sum += Integer.parseInt(value.getList().get(1).toString());
        }

        map.put(key.toString(), sum);

        output.add(new TwoTuple(key, String.valueOf(sum)));
    }


}
