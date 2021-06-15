package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example63 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>();

    public void reduce(ElemwntList list){
        String key = (String)list.getList().get(0).getList().get(0);
        Set<String> uvSet = new HashSet<>();
        long pv = 0;
        uvSet.clear();
        for (Element mid  : list.getList()) {
            pv++;
            uvSet.add(mid.getList().get(1).toString());
        }
        long uv = uvSet.size();
        String pvAndUv = pv + "\t" + uv;
        output.add(new TwoTuple(key, pvAndUv));
    }


}
