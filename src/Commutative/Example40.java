package Commutative;

import reduceExample.Element;
import reduceExample.ElemwntList;
import searchOnInternet.TwoTuple;

import java.util.ArrayList;
import java.util.List;

public class Example40 {

    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v ="";
    public void reduce(ElemwntList list)  {

        //String key = (String)list.getList().get(0).getList().get(0);

        //implement here
//		int nameNum=0;
//		int countNum=0;
        int sum = 0;
        String key = (String)list.getList().get(0).getList().get(0);
        ArrayList<String> a = new ArrayList<String>();
        ArrayList<String> b = new ArrayList<String>();
        String name=null;
        for (Element value : list.getList()) {
            String record=value.getList().get(1).toString();
            char type=record.charAt(0);
            if(type=='1')
            {
                sum += Integer.parseInt(value.getList().get(1).toString().trim());;
            }
            if(type=='2')
            {
                name=record.substring(1);
            }
        }
        if(name!=null&&String.valueOf(sum)!=null)
        {
            a.add(String.valueOf(sum));
            output.add(new TwoTuple(a.get(0).toString(),key));
        }

    }
}
