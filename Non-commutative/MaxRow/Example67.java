package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//MaxRow
//xx-xx-xx

public class Example67 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();

    private int max = Integer.MIN_VALUE;
    private int min = Integer.MIN_VALUE;
    private int total = 0;

    public void reduce(ElemwntList list){
        String key = (String)list.getList().get(0).getList().get(0);
        String maxItem = null;
        String minItem = null;
        for (Element value : list.getList()){
            total =total+ Integer.parseInt(value.getList().get(1).toString());
            if (max == Integer.MIN_VALUE && min == Integer.MIN_VALUE) {
                max = Integer.parseInt(value.getList().get(1).toString());
                min = Integer.parseInt(value.getList().get(1).toString());
                maxItem = String.valueOf(value.getList().get(2));
                minItem = String.valueOf(value.getList().get(2));
            } else {
                if (Integer.parseInt(value.getList().get(1).toString()) >= max){
                    max = Integer.parseInt(value.getList().get(1).toString());
                    maxItem = String.valueOf(value.getList().get(2));
                }

                else {
                    if (Integer.parseInt(value.getList().get(1).toString()) <= min){
                        min = Integer.parseInt(value.getList().get(1).toString());
                        minItem = String.valueOf(value.getList().get(2));
                    }

                }
            }
        }

        output.add(new TwoTuple(key, maxItem+" "+minItem));


    }
}
