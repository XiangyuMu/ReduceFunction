package searchOnInternet;

import java.util.ArrayList;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;
//https://github.com/josonle/MapReduce-Demo/blob/master/src/main/java/InputOutputFormatTest/MultiInOutput.java

//<String,int>(key,value)

//other
public class Example28 {
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
		for (Element value : list.getList()) {
			count++;
			if (count<3){
				continue;
			}
			sum =sum + Integer.parseInt(value.getList().get(1).toString());
			if (count>8){
				break;
			}
		}
		// 使用MultiOutputs对象替代Context对象输出
		// 1. 输出到不同文件（格式、文件名）
		if (key.toString().startsWith("2015"))
			output.add(new TwoTuple( key, "f2015 "+sum));
		else if (key.toString().startsWith("2016"))
			output.add(new TwoTuple( key, "f2016 "+sum));
		else
			output.add(new TwoTuple( key, "f2017 "+sum));
    }

}
