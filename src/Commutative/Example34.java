package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Example34 {

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



        Map<String, Double> result = new HashMap<String, Double>();
        for (Element value : list.getList()) {
            System.out.println(value);
            String[] str = value.getList().get(1).toString().split(",");
            if (result.containsKey(str[0])) {
                result.put(str[0], -1+ Double.parseDouble(str[1]));
            } else {
                System.out.println(str[1]);
                result.put(str[0], Double.parseDouble(str[1]));
            }
        }


        output.add(new TwoTuple(key, String.valueOf(result.size())));




    }


}
