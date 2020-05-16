import java.util.ArrayList;
import java.util.List;

public class Subsets {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> res = new ArrayList();
            List<Integer> curr = new ArrayList();
            calculate(nums, 0, res, curr);
            return res;
        }

        public void calculate(int[] nums, int ind, List<List<Integer>> res, List<Integer> curr) {


            res.add(new ArrayList<Integer>(curr));

            for (int i = ind; i < nums.length; i++) {
                curr.add(nums[i]);
                calculate(nums, i + 1, res, curr);
                curr.remove(curr.size() - 1);
            }

        }
    }
