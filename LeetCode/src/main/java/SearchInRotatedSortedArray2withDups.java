public class SearchInRotatedSortedArray2withDups {
        public boolean search(int[] nums, int target) {


            int l = 0, r=nums.length-1;
            if(r<0) return false;
            while(l<nums.length-1 && nums[l] == nums[l+1])
                l++;
            while(r>=l && nums[r] == nums[r-1])
                r--;
            while(l<=r) {
                int m = (l+r)/2;
                if(nums[m] == target ) return true;

                if(nums[m]<=nums[r] ) {
                    if (nums[m]<target && nums[r]>=target){
                        l = m+1;
                    }
                    else
                    {
                        r = m-1;
                    }
                }
                else if(nums[m]>=nums[l] ) {
                    if(nums[m]>target && nums[l]<=target)
                    {
                        r =m-1;
                    }
                    else
                    {
                        l = m+1;
                    }
                }

            }

            return false;
        }
    }
