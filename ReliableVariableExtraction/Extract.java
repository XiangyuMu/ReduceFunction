package ReliableVariableExtraction;

import java.io.IOException;

public class Extract {

    public static void main(String[] args) throws IOException {
        String filename = "Example";
        for (int i = 1;i<=100;i++){
            ExtractRV extractRV = new ExtractRV();
            try{
                if (i<10){
                    extractRV.Extract(filename+"0"+String.valueOf(i));
                }else {
                    extractRV.Extract(filename+String.valueOf(i));
                }
            }catch (Exception e){
                System.out.println("异常："+i);
            }

        }
    }

}
//21\24\51~57\65\84\90\91\97