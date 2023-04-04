package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//FirstN
//!-XX

public class Example79 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();


    public void reduce(ElemwntList list){
        float sum = 0;
        String key = (String)list.getList().get(0).getList().get(0);
        int count = 0;
        for (Element value  : list.getList()) {
            sum =sum + Float.parseFloat(value.getList().get(1).toString()) ;
            count++;
            if (count==8){
                break;
            }
        }
        output.add(new TwoTuple(key, String.valueOf(sum)));

    }

}
