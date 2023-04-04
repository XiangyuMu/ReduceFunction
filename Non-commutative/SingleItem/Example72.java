package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//SingleItem
public class Example72 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    ElemwntList gl = new ElemwntList();

    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        Object x = null;
        for (Element el:list.getList()){
            x = el.getList().get(1);
        }
        output.add(new TwoTuple(key, String.valueOf(x)));
    }


}
