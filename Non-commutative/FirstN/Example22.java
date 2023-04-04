package searchOnInternet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import reduceExample.Element;
import reduceExample.ElemwntList;

//<String,String>(key,value)

//FirstN
public class Example22 {
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

    	 int sum = 0;
        int count = 0;
        for (Element value:list.getList()){
            sum =sum+ Integer.parseInt(value.getList().get(1).toString()) ;
            count++;
            if (count>7){
                break;
            }
        }
         output.add(new TwoTuple(key, sum+""));
    }


}
