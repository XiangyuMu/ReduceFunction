package searchOnInternet;

import java.util.ArrayList;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;
//https://github.com/josonle/MapReduce-Demo/blob/master/src/main/java/weblog/PVMinMax2.java

//<String,String>(key,value)

//MaxRow
public class Example37 {
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	int maxVisit = 0;					//默认最大值设为0
	int minVisit = Integer.MAX_VALUE;	//默认最小值设为最大整数
	String maxMinute = null;// 最大访问量的所在时间
	String minMinute = null;
	public List<TwoTuple> getOutput() {
		return output;
	}
	public void setOutput(List<TwoTuple> output) {
		this.output = output;
	}
    public void reduce(ElemwntList list)  {

    	String key = (String)list.getList().get(0).getList().get(0);

    	for (Element val : list.getList()) {
			String[] strs = val.getList().get(1).toString().split(":");
			String minute = strs[1];				//minute:访问时间，如：17:38
			int visit = Integer.parseInt(strs[0]);	//visit:访问次数,如：813
			if (visit > maxVisit) {
				maxVisit = visit;
				maxMinute = minute;
			}					
			if (visit < minVisit) {
				minVisit = visit;
				minMinute = minute;
			}
		}
		String value = maxMinute + " " + maxVisit + "\t" + minMinute + " " + minVisit;
		output.add(new TwoTuple(key, value));
		
    }



}
