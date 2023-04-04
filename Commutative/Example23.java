package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example23 {

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
        String title = "";

        // Add up all the ratings
        for (Element value: list.getList()) {
            // Separate the value from the tag
            String parts[] = value.getList().get(1).toString().split("\t");

            if (parts[0].equals("title")) {
                // Get the title
                title = parts[1];
            }
            else {
                // Get a rating for this title
                double ratingValue = Double.parseDouble(parts[1]);
                avgRating += ratingValue;
                numValues++;
            }
        }

        // Divide by the number of ratings to get the average for this movie
        avgRating /= numValues;

        String outputValue = title + "\n" + avgRating;
        output.add(new TwoTuple(key, outputValue));

    }


}
