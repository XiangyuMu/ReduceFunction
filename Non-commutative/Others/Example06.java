package searchOnInternet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import reduceExample.Element;
import reduceExample.ElemwntList;

//����<String,int>(key,value1,value2)   value<=25
//���и��Ӽ���
//Other
public class Example06 {

	
	public List<TwoTuple> getOutput() {
		return output;
	}
	public void setOutput(List<TwoTuple> output) {
		this.output = output;
	}
	
	List<TwoTuple> output = new ArrayList<TwoTuple>() ;
	String v = "";
	public void reduce(ElemwntList list) {
		String key = (String)list.getList().get(0).getList().get(0);

        //��ʼ�����ʾ���,���ʾ���ֻ��һ��,���������û�����ͬ
        //�û���
        int nums = 25;
        float[] G = new float[nums];
        //���ʾ����ֵΪpr��ʽ��(1-d)/n�Ĳ���
        //����ϵ��
        float d = 0.85f;
        Arrays.fill(G, (1 - d) / nums);
        //�����û��ڽӾ���
        float[] U = new float[nums];
        //���û���������
        int out = 0;
        StringBuilder printSb = new StringBuilder();
        for (Element value : list.getList()) {
            //��value���õ�Ŀ���û���id
            int targetUserIndex = Integer.parseInt(value.getList().get(1).toString());
            //�ڽӾ�����ÿ��Ŀ���û���Ӧ��ֵΪ1,����Ϊ0
            U[targetUserIndex - 1] = Integer.parseInt(value.getList().get(2).toString());
            out++;
            printSb.append(",").append(value.getList().get(1).toString());
        }
        //��ӡreducer������
        System.out.println("AdjacencyReducer input:");
        System.out.println(key.toString() + ":" + printSb.toString().replaceFirst(",", ""));

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums; i++) {
            stringBuilder.append(",").append(G[i] + U[i] * d / out);
        }
        v=(stringBuilder.toString().replaceFirst(",", ""));
        System.out.println("AdjacencyReducer output:");
        System.out.println(key.toString() + ":" + v.toString());
        System.out.println();
        output.add(new TwoTuple(key,v));
        }



}