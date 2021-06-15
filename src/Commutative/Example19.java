package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example19 {

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
        int     totalSalary = 0;

        for (Element value : list.getList()) {
            String [] lineSplit = value.getList().get(1).toString().split("~");
            String fileTag = lineSplit[0].trim();
            String fileValue = lineSplit[1].trim();

            if (fileTag.equals("EMPLOYEE"))
            {
                totalSalary += Integer.parseInt(fileValue);
            }
        }
        output.add(new TwoTuple(String.valueOf(key),String.valueOf(totalSalary)));

    }
}
