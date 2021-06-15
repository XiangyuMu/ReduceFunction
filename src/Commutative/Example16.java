package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Example16 {

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
        double avg= 0.0  ;
        int count = 0;

        double finalavg=0.0 ;

        for (Element value : list.getList()) {

            if (!((Double) value.getList().get(1)).isInfinite() && !((Double)value.getList().get(1)).isNaN()) {
                BigDecimal bigDecimal = new BigDecimal(avg+=(Double) value.getList().get(1));
                //double avgearning = bd.doubleValue();
                finalavg = bigDecimal.doubleValue();
                count++;
            }
        }
        if (count!=0) {

            double avg2= (finalavg/count);
            double avgearning= Math.round((avg/count)* 100.0)/100.0;
            // double avgearning = bd.doubleValue();
            //double avgearning= Math.round((avg/count)* 100.0)/100.0;
            output.add(new TwoTuple(String.valueOf(key),String.valueOf(avgearning)));
        }

    }
}
