package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//FirstN


public class Example70 {
    private double totalSum = 0;
    private int totalCount = 0;
    private double average = 0;
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();
    public void reduce(ElemwntList list){

        String key = (String)list.getList().get(0).getList().get(0);
        for (Element value : list.getList()){
            totalSum =totalSum+Integer.parseInt(value.getList().get(1).toString()) ;
            totalCount++;
            if (totalCount==8){
                break;
            }
        }
        average = totalSum / totalCount;
        output.add(new TwoTuple(key, String.valueOf(average)));
    }



}
