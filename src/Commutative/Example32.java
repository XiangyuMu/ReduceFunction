package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example32 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;

    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        int wordCount = 0;
        int sum = 0;
        for (Element val : list.getList()) {
            sum += Integer.parseInt(val.getList().get(1).toString());
        }
        output.add(new TwoTuple(key, String.valueOf(sum)));
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
