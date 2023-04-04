package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Example21 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    public void reduce(ElemwntList list) {
        //使用set集合记性独立ip统计
//		String key = (String)list.getList().get(0).getList().get(0).getAtom();
        String key = "1";
        Set<String> ips = new HashSet<String>();

        for (Element ip : list.getList()) {
            ips.add(ip.getList().get(1).toString());
        }
        int count =ips.size();
        output.add(new TwoTuple(key,""+ips));
    }

}
