package leetcode;

import java.util.Arrays;

public class LastStoneWeight {

        public static int lastStoneWeight(int[] stones) {
            Arrays.sort(stones);
            int i;
            for(i = stones.length-1 ; i>0 ;){
                if(stones[i]==stones[i-1]){
                    i = i-2;

                }
                else{
                    stones[i-1] = stones[i] - stones[i-1];
                    i  = i-1;
                    Arrays.sort(stones);

                }
            }
            if(i==0) return stones[0];
            return 0;

        }
    }

