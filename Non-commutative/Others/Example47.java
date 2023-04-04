package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



//SingleItem

public class Example47 {
    List<TwoTuple> output = new ArrayList<>();
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void reduce(ElemwntList list)  {
        String key = (String)list.getList().get(0).getList().get(0);
        String output1 = "";
        for (Element value:list.getList()){
            output1 = value.getList().get(1).toString() + "~";
        }

        StringTokenizer outputTokenizer = new StringTokenizer(output1,"~");
        if(outputTokenizer.countTokens()>=2)
        {
            output1 = output1.replace("~", ",");

            output.add(new TwoTuple(key, output1));
        }
    }

}
