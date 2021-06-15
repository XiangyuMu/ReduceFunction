package searchOnInternet;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import reduceExample.Element;
import reduceExample.ElemwntList;
//https://github.com/josonle/MapReduce-Demo/blob/master/src/main/java/ssdut/training/mapreduce/topten/TopTenReducer.java

//<String,String>(key,value)

//other
public class Example36 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	public List<TwoTuple> getOutput() {
		return output;
	}
	public void setOutput(List<TwoTuple> output) {
		this.output = output;
	}

	float gradesSum;
    public void reduce(ElemwntList list)  {
		TreeMap<Integer, String> visitMap = new TreeMap<Integer, String>();
    	String key = (String)list.getList().get(0).getList().get(0);

    	for (Element val : list.getList()) {
			String[] strs = val.getList().get(1).toString().split(" ");
			visitMap.put(Integer.parseInt(strs[1]), val.getList().get(1).toString());	//将访问次数（KEY）和行记录（VALUE）放入TreeMap中自动排序
			if (visitMap.size() > 8) {		//如果TreeMap中元素超过N个，将第一个（KEY最小的）元素删除
				visitMap.remove(visitMap.firstKey());
			}
		}
    	output.add(new TwoTuple(key,visitMap.toString()));
    }

}
