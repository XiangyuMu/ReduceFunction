package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;


//other

//xx-xx(A xxx\Positive Review\Negative Review)

public class Example68 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();

    public void reduce(ElemwntList list){
        String restaurantName = "";
        int posCount = 0;
        int negCount = 0;
        for (Element value : list.getList()){
            String[] val = value.getList().get(1).toString().split(" ");
            if (val[0].equalsIgnoreCase("A"))
                restaurantName = val[1];
            if (value.getList().get(1).toString().equalsIgnoreCase("pr"))
                posCount++;
            if (value.getList().get(1).toString().equalsIgnoreCase("nr"))
                negCount++;

        }

        if (posCount > 0 || negCount > 0) {
            if (!restaurantName.isEmpty()) {
                output.add(new TwoTuple(restaurantName, posCount+" "+negCount));
            }
        }


    }
}
