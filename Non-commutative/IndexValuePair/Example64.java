package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//IndexValuePair


public class Example64 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();
    public void reduce(ElemwntList list){
        int count = 0;
        HashMap<String, Double> map = new HashMap<>();
        for (Element tuple : list.getList()) {
            map.put(tuple.getList().get(1).toString(), Double.parseDouble(tuple.getList().get(2).toString()) );
            count++;
        }
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            output.add(new TwoTuple(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
        }
    }

}
