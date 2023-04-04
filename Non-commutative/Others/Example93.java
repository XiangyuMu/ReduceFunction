package searchOnInternet;

import reduceExample.ElemwntList;

import java.util.ArrayList;
import java.util.List;
//<String,String>(key,value)

//other

public class Example93 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v ="";
    public void reduce(ElemwntList list)  {

        String key = (String)list.getList().get(0).getList().get(0);

        int i = 0;
        while (i<list.getList().size()) {
            String inputDoc = (String) list.getList().get(i).getList().get(1);
            System.out.println(inputDoc);
            boolean keep = inputDoc.isEmpty();
            i++;
            if (keep) {
                inputDoc="BehemothReducer";
            }
            if (key.equal(1)||key.equal(2)){
                output.add(new TwoTuple(key, inputDoc));
           }
        }
    }
}
