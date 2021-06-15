package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import reduceExample.Element;
import reduceExample.ElemwntList;

//<String,String>(key,value)

//other
public class Example17 {
	
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
    	Set<String> attackers = new TreeSet<String>();
    	int i = 0;
    	for (Element value:list.getList()){
			i = i+1;
			if(i == 0) {
				continue;
			}
			String valStr = value.getList().get(1).toString();
			attackers.add(valStr);
			System.out.println(valStr);
		}

        output.add(new TwoTuple(key, attackers.toString()));
    }
}
