package leetcode;

import java.util.Arrays;

public class RightInterval {

        public int[] findRightInterval(int[][] intervals) {

            int min = intervals[0][0];
            int max = intervals[0][1];
            for(int[] row : intervals){
                min = Math.min(min,row[0]);
                max = Math.max(max,row[1]);
            }

            //bucket save the index of interval at interval[0]-min
            int[] bucket = new int[max-min+1];
            Arrays.fill(bucket,-1);
            int i = 0;
            for(int[] row : intervals){
                bucket[row[0]-min] = i;
                i++;
            }

            int[] result = new int[intervals.length];

            for(i = bucket.length-2 ; i>=0 ;i--){
                if(bucket[i]==-1)
                    bucket[i] = bucket[i+1];
            }
            //System.out.println(Arrays.toString(bucket));
            i = 0;
            for(int[] row: intervals){
                result[i] = bucket[row[1]-min];
                i++;
            }

            return result;

        }
    }

