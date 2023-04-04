package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

//IndexValuePair


public class Example63 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();


    public void reduce(ElemwntList list){
        TreeMap<Integer, String> map = new TreeMap<>();
        double ratingSum = 0;
        int count = 0;
        for (Element value  : list.getList()) {
            ratingSum = ratingSum+Double.parseDouble(value.getList().get(1).toString()) ;
            count =count+ Integer.parseInt(value.getList().get(2).toString());
            map.put(Integer.parseInt((String) value.getList().get(1)),value.getList().get(2).toString());
        }
        double averageRating = ratingSum / count;
        output.add(new TwoTuple(String.valueOf(averageRating), map.toString()));
    }

}
