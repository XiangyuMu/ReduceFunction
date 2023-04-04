package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//other
public class Example74 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    ElemwntList gl = new ElemwntList();


    public void reduce(ElemwntList list) {
        List<String> names = new ArrayList<String>();
        String key = (String)list.getList().get(0).getList().get(0);
        for(Element el : list.getList()) {
            names.add((String) el.getList().get(1));
        }
        String s = String.join("|", names);
        output.add(new TwoTuple(key, s));
    }



}
