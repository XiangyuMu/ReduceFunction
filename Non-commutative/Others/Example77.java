package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//other


public class Example77 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");
    List<TwoTuple> output = new ArrayList<TwoTuple>();

    public void reduce(ElemwntList list){
        String key = (String)list.getList().get(0).getList().get(0);

        int measures = 0;
        double totalCo = 0.0f;

        for (Element coValue : list.getList()) {
            totalCo =totalCo+ Double.parseDouble(coValue.getList().get(1).toString());
            measures++;
            if (measures==4){
                break;
            }
        }

        if (measures > 0) {
            output.add(new TwoTuple(key, decimalFormat.format(totalCo / measures)));

        }

    }


}