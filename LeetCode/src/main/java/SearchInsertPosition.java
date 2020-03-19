public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) { int low = 0,high = nums.length-1;
       int mid=0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high = mid-1;
        }
        if(nums[mid]<target) return  mid+1>nums.length?nums.length:mid+1;
        else return mid<0?0:mid;

    }
}
