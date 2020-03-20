public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1,-1};
        int left = binarySearch(nums,target,0,nums.length-1);
        if(left==-1) return result;
        int right = left;


        while(left>0){
            result[0] = left;
            left=binarySearch(nums,target,0,left-1);

        }
        while(right!=-1 && right!=nums.length-1){
            result[1]= right;
            right=binarySearch(nums,target,right+1,nums.length-1);
        }
        if(left!=-1) result[0]=left;
        if(right!=-1) result[1]=right;
        return result;

    }

    public int binarySearch(int[] nums, int target,int low, int high){
        int mid=0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid]<target) low = mid+1;
            else high = mid-1;
        }
        return -1;
    }
}