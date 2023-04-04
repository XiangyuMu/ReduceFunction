package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Example17 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v = "";
    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        int totalSalary = 0;
        int headCount = 0;
        for (Element value : list.getList()) {
            totalSalary += Integer.parseInt(value.getList().get(1).toString());
            headCount++;
        }

        float        avgSalary = (float)1.0 * totalSalary / headCount;
        String        value = "" + headCount + "\t" + avgSalary;
        output.add(new TwoTuple(String.valueOf(key),String.valueOf(value)));

    }
}
