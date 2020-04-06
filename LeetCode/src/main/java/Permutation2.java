
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] flag = new boolean[nums.length];

        calculate(nums,result,current,flag);
        return result;
    }

    public void calculate(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] flag){
        if(current.size() == nums.length)
        {
            result.add(new ArrayList<>(current));
            return;

        }
        for(int i = 0 ; i < nums.length ; i++) {
            if(flag[i]) continue;
            if(i>0 && nums[i]==nums[i-1] && !flag[i-1]) continue;
            current.add(nums[i]);
            flag[i] = true;
            calculate(nums,result,current,flag);
            flag[i] = false;
            current.remove(current.size()-1);
        }
    }

}
