package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example27 {

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
        int sum = 0;
        List<String> ids = new ArrayList<String>();

        for (Element value : list.getList()) {
            String id_str = value.toString().split("\\\\")[1];
            if (!ids.contains(id_str)) {
                ids.add(id_str);
            }
        }
        sum = ids.size();

        output.add(new TwoTuple(key, String.valueOf(sum)));
    }


}
