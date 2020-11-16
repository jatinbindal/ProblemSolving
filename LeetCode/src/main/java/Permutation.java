import java.util.ArrayList;
import java.util.List;

//general approach to baktracking
public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>  result = new ArrayList<>();
        List<Integer> currenRes = new ArrayList<>();
        calculate(result, currenRes, nums);
        return result;
    }

    public void calculate(List<List<Integer>> result, List<Integer> curr, int[] nums){
        if(curr.size() == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0 ; i< nums.length ;i++){
            if(curr.contains(nums[i])) continue;
            curr.add(nums[i]);
            calculate(result,curr,nums);
            curr.remove(curr.size()-1);
        }
    }
}
