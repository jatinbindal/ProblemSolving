package leetcode;

public class SortColors {
    public void sortColors(int[] nums) {
        //Dutch partioning algorithm
        int low=0,reader=0,high=nums.length-1;

        while(low<=high){
            if(nums[low]==0){
                nums[low] = nums[reader];
                nums[reader] = 0;
                low++;
                reader++;
            }
            else if(nums[low]==1) low++;
            else{
                nums[low]=nums[high];
                nums[high]=2;
                high--;

            }
        }
    }

}
