package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;


//other


public class Example44 {
    List<TwoTuple> output = new ArrayList<>();
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void reduce(ElemwntList list)  {
        // input: <col, row1=element1, row2=element2, ..., v>
        // output: <row, element * v>


        double vecCell = 0.0;
        List<String> matrixRow = new ArrayList<>();
        for (Element value : list.getList()) {
            String val = value.getList().get(1).toString();
            if (val.contains("=")) {
                matrixRow.add(val);
            } else {
                vecCell = Double.parseDouble(val);
            }
        }

        for (String rowVal : matrixRow) {
            String row = rowVal.split("=")[0];
            double value = Double.parseDouble(rowVal.split("=")[1]) * vecCell;
            output.add(new TwoTuple(row, String.valueOf(value)));
        }
    }
}
