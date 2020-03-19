import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {

        //Fixed 2 numbsers, found third using binary search
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int tempSum, target =0, req;
        int prevI = Integer.MIN_VALUE;
        int prevJ = Integer.MIN_VALUE;
        for(int i=0;i<=nums.length-3;i++){
            if(nums[i]==prevI) continue;
            prevI = nums[i];
            for(int j=i+1;j<=nums.length-2;j++){
                if(nums[j]==prevJ) continue;
                prevJ = nums[j];
                tempSum = nums[i]+nums[j];
                req = target - tempSum;
                boolean found = binarySearch(nums,req,j+1,nums.length-1);
                if(found){
                    List<Integer> ans = new ArrayList();
                    ans.add(nums[i]);
                    ans.add(nums[j]);
                    ans.add(req);
                    result.add(ans);
                }

            }
        }
        return result;
    }

    public static  boolean binarySearch(int[] nums, int req, int low, int high){
        int mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == req) return true;
            else if(nums[mid]<req) low = mid+1;
            else high = mid-1;
        }
        return false;
    }
}

