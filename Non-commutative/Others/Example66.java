package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;
//other

public class Example66 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();

    public void reduce(ElemwntList list){
        String key = (String)list.getList().get(0).getList().get(0);
        if (Integer.parseInt(key)>0){
            for (Element value : list.getList()){
                output.add(new TwoTuple(key, String.valueOf(value.getList().get(1))));
            }
        }

    }
}
