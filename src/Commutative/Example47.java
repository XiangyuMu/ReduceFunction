package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example47 {
    private double allT = 0;
    private double allF = 0;
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();
    public void reduce(ElemwntList list){

        String key = (String)list.getList().get(0).getList().get(0);
        if(key.equals("T")){
            for(Element val: list.getList()){
                allT =allT+ Integer.parseInt(val.getList().get(1).toString());
            }
        }
        else{
            for(Element val: list.getList()){
                allF = allF + Integer.parseInt(val.getList().get(1).toString());
            }
        }
        output.add(new TwoTuple(key, String.valueOf(allF+allT)));
    }
}
