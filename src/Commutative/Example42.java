package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example42 {
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v ="";
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    public void reduce(ElemwntList list)  {

        String key = (String)list.getList().get(0).getList().get(0);

        int sumOfTemperatures = 0;
        int nbValues = 0;
        for (Element value : list.getList()) {
            sumOfTemperatures = sumOfTemperatures + Integer.parseInt(value.getList().get(1).toString());
            nbValues++;
            if (nbValues>8){
                break;
            }
        }
        int average = sumOfTemperatures / nbValues;
        output.add(new TwoTuple(key, average+""));
    }




}
