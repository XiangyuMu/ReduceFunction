package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example24 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v = "";

    String userId = "";
    String itermScore = "";
    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        double avgRating = 0;
        int numValues = 0;

        // Add up all the ratings
        for (Element value: list.getList()) {
            avgRating += Integer.parseInt(value.getList().get(1).toString());
            numValues++;
        }

        // Divide by the number of ratings to get the average for this movie
        avgRating /= numValues;


        // Output the average rating for this movie
        output.add(new TwoTuple(key, String.valueOf(avgRating)));

    }


}
