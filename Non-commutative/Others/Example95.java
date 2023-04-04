package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;
//<String,String>(key,value)

//other


public class Example95 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v ="";
    float gradesSum;
    public void reduce(ElemwntList list)  {

        String key = (String)list.getList().get(0).getList().get(0);

        for (Element value : list.getList()) {
            // 排序后再次颠倒k-v，将日期作为key
            System.out.println(value.getList().get(1).toString()+":"+key);
            output.add(new TwoTuple(value.getList().get(1).toString(), key));
        }
    }

}
