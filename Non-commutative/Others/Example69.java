package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;

//other

//xx-xx(a or b)

public class Example69 {
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    List<TwoTuple> output = new ArrayList<TwoTuple>();

    private ArrayList<String> listA = new ArrayList<String>();
    private ArrayList<String> listB = new ArrayList<String>();


    public void reduce(ElemwntList list){
        listA.clear();
        listB.clear();
        String key = (String)list.getList().get(0).getList().get(0);
        for (Element value : list.getList()){
            String chr = value.getList().get(1).toString().substring(0, 1);
            if (chr.equalsIgnoreCase("a"))
                listA.add(value.toString().substring(1));
            else if (chr.equalsIgnoreCase("b"))
                listB.add(value.toString().substring(1));
        }
        output.add(new TwoTuple(key,listA.toString()));
    }

}
