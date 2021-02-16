package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountingElements {
    public int countElements(int[] arr) {

        int count = 0;
        Set<Integer> num = new HashSet<>();
        for(int i = 0 ;i < arr.length ; i++){
            num.add(arr[i]);
        }
        for(int i = 0 ; i < arr.length ; i++){
            if(num.contains(arr[i]+1)) count++;
        }
        return count;
    }
}