package searchOnInternet;

import java.util.ArrayList;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;

//<String,String>(key,value)

//FirstN
public class Example16 {
	
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
    	 Double mx = 0d;
         Double my = 0d;
         int counter = 0;

         for (Element value : list.getList()) {
             String[] temp = value.getList().get(1).toString().split(" ");
             mx += Double.parseDouble(temp[0]);
             my += Double.parseDouble(temp[1]);
             counter ++;
             if(counter==9){
                 break;
             }
         }

         mx = mx / counter;
         my = my / counter;
         String centroid = mx + " " + my;

         output.add(new TwoTuple(centroid, key));
    }
}
