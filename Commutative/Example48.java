package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example48 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v ="";
    float gradesSum;
    public void reduce(ElemwntList list)  {

        String key = (String)list.getList().get(0).getList().get(0);

        String friendList = "";
        for (Element value : list.getList()) {
            friendList = friendList+ value.getList().get(1).toString()+",";
        }
        // 输出个人所有好友，A	I,K,C,B,G,F,H,O,D
        output.add(new TwoTuple(key, friendList.substring(0,friendList.length())));
    }

}
