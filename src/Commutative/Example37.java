package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example37 {

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
        String recordKey = key.toString();
        String authorId = recordKey.substring(0);

        Integer reputation = 0;
        int postsNumber = 0;
        for (Element value: list.getList()){
            reputation = Integer.parseInt((String) value.getList().get(1)) ;
            postsNumber++;
        }

        v = (reputation + "\t" + postsNumber);
        output.add(new TwoTuple(authorId,v ));
    }
}
