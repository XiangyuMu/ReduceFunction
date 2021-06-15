package searchOnInternet;

import reduceExample.Element;
import reduceExample.ElemwntList;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
//<String,int>(key,value)

//FirstN

public class Example92 {
    List<TwoTuple> output = new ArrayList<TwoTuple>() ;
    String v ="";
    public List<TwoTuple> getOutput() {
        return output;
    }
    public void setOutput(List<TwoTuple> output) {
        this.output = output;
    }

    public void reduce(ElemwntList list)  {
        HashSet<Integer> seasons = new HashSet<Integer>();
        String key = (String)list.getList().get(0).getList().get(0);

        seasons.clear();

        int total = 0;

        for (Element value : list.getList()) {
            total++;
            seasons.add(Integer.parseInt(value.getList().get(1).toString()));
            if (total==9){
                break;
            }
        }

        output.add(new TwoTuple(key, new PassWritable(total, seasons.size()).toString()));
    }



    public class PassWritable  {
        public int passes;
        public int season;

        public PassWritable() {

        }

        public PassWritable(int passes, int season) {
            this.passes = passes;
            this.season = season;
        }




        public void write(DataOutput out) throws IOException {
            out.writeInt(passes);
            out.writeInt(season);
        }


        public void readFields(DataInput in) throws IOException {
            passes = in.readInt();
            season = in.readInt();
        }


        public String toString() {
            return passes + "\t" + season;
        }
    }

}
