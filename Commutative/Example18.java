package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Example18 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    LinkedList<Integer> incomeList = new LinkedList<Integer>();
    LinkedList<String>  nameList = new LinkedList<String>();
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v = "";
    public void reduce(ElemwntList list) {
        String key = (String)list.getList().get(0).getList().get(0);
        for (Element value : list.getList()) {
            String[] lineSplit = value.getList().get(1).toString().split("~");

            String employeeName = lineSplit[0].trim();
            int income = Integer.parseInt(lineSplit[1].trim());

            System.out.println("name = " + employeeName + ", income = " + income);
            updateList(employeeName, income);
        }

        for (int i = 0; i < incomeList.size(); i++)
        {
            output.add(new TwoTuple(String.valueOf(key),nameList.get(i) + "\t" + incomeList.get(i)));
        }
    }

    private void updateList(String name, int income)
    {
        boolean done = false;

        for (int i = 0; i < incomeList.size(); i++)
        {
            if (income > incomeList.get(i))
            {
                incomeList.add(i, income);
                nameList.add(i, name);

                done = true;
                break;
            }
        }

        if (false == done)
        {
            incomeList.add(income);
            nameList.add(name);
        }
    }

}
