package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


//IndexValuePair

public class Example53 {
    ElemwntList gl = new ElemwntList();
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        Object x = null;
        Object y = null;
        Map mp = new HashMap();
        int test1;
        for (Element el:list.getList()){
            x = el.getList().get(1);
            y = el.getList().get(2);
            if(!mp.containsKey(x)) {
                mp.put(x, y);
            }
        }
        output.add(new TwoTuple(key, mp.toString()));
    }


}
