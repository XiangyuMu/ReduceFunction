package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Example62 {
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    float gradesSum;
    public void reduce(ElemwntList list)  {
        TreeMap<Integer, String> visitMap = new TreeMap<Integer, String>();
        String key = (String)list.getList().get(0).getList().get(0);

        for (Element val : list.getList()) {
            String[] strs = val.getList().get(1).toString().split(" ");
            visitMap.put(Integer.parseInt(strs[1]), val.getList().get(1).toString());
        }
        output.add(new TwoTuple(key,visitMap.toString()));
    }

}
