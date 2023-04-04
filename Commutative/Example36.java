package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example36 {

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
        int postsNumber = 0;
        int reputation = 0;
        String authorId = key.toString();

        for (Element value : list.getList()) {

            int intValue = Integer.parseInt((String) value.getList().get(1)) ;
            if (intValue == 1) {
                postsNumber ++;
            }
        }
        output.add(new TwoTuple(authorId,String.valueOf(postsNumber) ));
    }
}
