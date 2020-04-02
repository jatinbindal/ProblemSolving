import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class GrayCode {
    public  List<Integer> grayCode(int n) {
        HashMap<String,Integer>  binaryToInt= new HashMap<>();
        int powN =  (int)Math.pow(2,n);
        List<String> grayList = new ArrayList<>();
        for(int i = 0 ; i < powN ; i++ ){

            String binary = Integer.toBinaryString(i);
            if(binary.length()<n){
                StringBuilder zero = new StringBuilder();
                for(int j = 1 ; j <= n-binary.length();j++){
                    zero.append('0');
                }
                binary = zero.append(binary).toString();
            }

            binaryToInt.put(binary,i);
            grayList.add(binaryToGray(binary));
        }

        List<Integer> result = new ArrayList<>();
        result = grayList.stream().map(e->{return binaryToInt.get(e);}).collect(Collectors.toList());
        return  result;
    }

    public char xor_char(char a,char b){
        return a==b?'0':'1';
    }

    public String binaryToGray(String binary){
    StringBuilder gray = new StringBuilder("");
    gray.append(binary.charAt(0));
    for(int i =1;i<=binary.length()-1;i++){
        gray.append(xor_char(binary.charAt(i),binary.charAt(i-1)));
    }
    return gray.toString();
    }
}