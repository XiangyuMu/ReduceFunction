package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//SingeItem
public class Example73 {
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

        boolean flag = true;
        for (Element el:list.getList()){
            if(flag) {
                flag = false;
                x = el.getList().get(1);
            }
        }
        output.add(new TwoTuple(key, String.valueOf(x)));


    }




}
