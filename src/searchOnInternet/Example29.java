package searchOnInternet;

import java.util.ArrayList;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;
//https://github.com/josonle/MapReduce-Demo/blob/master/src/main/java/InvertedIndex/InvertedReducer.java

//<String,String>(key,value)

//StrConcat
public class Example29 {
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

    	String fileList = new String();
		for (Element value : list.getList()) {
			fileList =fileList+ value.getList().get(1).toString() + "; ";
		}
		
		output.add(new TwoTuple(key, fileList));		//Êä³ö¸ñÊ½£º"word	file1:num1; file2:num2;"
    }

}
