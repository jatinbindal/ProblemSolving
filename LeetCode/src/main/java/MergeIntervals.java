import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//sort intervals
// compare and add to list
// use better sort for lil better performance
public class MergeIntervals {

        public int[][] merge(int[][] intervals) {

            List<int[]> res = new ArrayList<>();
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            res.add(intervals[0]);
            int j = 0;
            for(int i = 1 ; i < intervals.length ; i++){
                if(intervals[i][0] <= res.get(j)[1]){
                    res.get(j)[1] = Math.max(intervals[i][1], res.get(j)[1]);
                }
                else{
                    j++;
                    res.add(intervals[i]);
                }
            }

            return res.toArray(new int[res.size()][]);
        }
    }
