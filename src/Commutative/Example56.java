package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example56 {

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
        int sum = 0;
        int grades = 0;
        for (Element val : list.getList()) {
            sum =sum + 1;
            grades =grades+ Integer.parseInt((String) val.getList().get(1));
        }
        System.out.println("Reduce----student is:"+key.toString()+",grades is:"+grades+",sum is:"+sum);
        gradesSum=(float)grades/sum;
        output.add(new TwoTuple(key, Float.toString(gradesSum)));
    }

}
