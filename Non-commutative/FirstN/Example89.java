package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//FirstN

public class Example89 {
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
            if (pv==8){
                break;
            }
        }
        long uv = uvSet.size();
        String pvAndUv = pv + "\t" + uv;
        output.add(new TwoTuple(key, pvAndUv));
    }


}
