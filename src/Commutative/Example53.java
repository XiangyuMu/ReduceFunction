package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.Example46;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example53 {
    List<TwoTuple> output = new ArrayList<>();
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void reduce(ElemwntList list)  {

        Result result = new Result();
        int sum = 0;
        float count = 0;
        String key = (String)list.getList().get(0).getList().get(0);
        for (Element val : list.getList()) {
            sum = sum + Integer.parseInt(val.getList().get(1).toString()) * Integer.parseInt(val.getList().get(2).toString());
            count = count + Integer.parseInt(val.getList().get(1).toString());
        }

        result.setCount(sum);
        result.setAverage(sum / count);
        output.add(new TwoTuple(key, result.toString()));

    }



    class Result{
        int count;
        float average;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public float getAverage() {
            return average;
        }

        public void setAverage(float average) {
            this.average = average;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "count=" + count +
                    ", average=" + average +
                    '}';
        }
    }
}
