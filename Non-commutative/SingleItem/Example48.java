package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//SingleItem
public class Example48 {
    List<TwoTuple> output = new ArrayList<>();
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void reduce(ElemwntList list) {
        int measures = 0;
        double totalCo = 0.0f;
        String key = (String)list.getList().get(0).getList().get(0);
        for (Element coValue : list.getList()) {
            totalCo = totalCo + Double.parseDouble(coValue.getList().get(1).toString());
            measures++;
            break;
        }
        if (measures > 0) {
            output.add(new TwoTuple(key, (totalCo / measures)+""));
        }
    }
}
