package searchOnInternet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;

//<String,int>(key,value)

//MaxRow
public class Example38 {
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

		int max = 0;
		String maxStr = "";
		for (Element value : list.getList()){
			int v = Integer.parseInt(value.getList().get(1).toString());
			if(v>max) {
				max = v;
				maxStr = value.getList().get(2).toString();
			}
		}
    	//Logger.println(context.getConfiguration(), "Reducing ts=" + timestamp);
		output.add(new TwoTuple(key,maxStr));
    }

}