package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
//<String,String>(key,value)

//other


public class Example88 {
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    int maxVisit = 0;
    int minVisit = Integer.MAX_VALUE;
    String maxMinute = null;
    String minMinute = null;
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    public void reduce(ElemwntList list)  {

        String key = (String)list.getList().get(0).getList().get(0);

        String nodes = "UNMODED";
        String word = "";
        int lowest = 125; // In this 125 is considered as infinite distance
        for (Element values: list.getList()){
            String[] sp = values.getList().get(1).toString().split(" "); // splits on
            if (sp[0].equalsIgnoreCase("NODES")) {
                nodes = null;
                nodes = sp[1];
            } else if (sp[0].equalsIgnoreCase("VALUE")) {
                int distance = Integer.parseInt(sp[1]);
                if (distance<lowest){
                    lowest = distance;
                }
            }
        }
        word=lowest + " " + nodes;
        output.add(new TwoTuple(key, word));
        word="";

    }





}
