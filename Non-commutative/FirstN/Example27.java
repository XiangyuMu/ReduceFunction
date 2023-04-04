package searchOnInternet;

import java.util.ArrayList;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;

//<String,int>(key,value)

//FirstN
public class Example27 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v ="";
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);

    	int count = 0;
    	int numTotalTweets = 0;
        for (Element value : list.getList()) {
            numTotalTweets = numTotalTweets+Integer.parseInt(value.getList().get(1).toString());
            count++;
            if (count==5){
                break;
            }
        }
        output.add(new TwoTuple(key,Integer.toString(numTotalTweets)));
    }

}
