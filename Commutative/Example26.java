package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example26 {

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
        long sum_area = 0;	//面积
        float sum_price = 0;	//价格
        float avprice;	//均价
        long count = 0;	//区域的出租屋总量

        for (Element value : list.getList()) {
            if (Integer.parseInt(value.getList().get(1).toString()) > 10 && Integer.parseInt(value.getList().get(1).toString()) < 100) {
                sum_area += Integer.parseInt(value.getList().get(2).toString());
                sum_price += Integer.parseInt(value.getList().get(3).toString());
            }
            count++;
        }
        avprice = sum_price / (float)sum_area;

        output.add(new TwoTuple(key, String.valueOf(avprice)));
    }


}
