public class FirstMissingPositive {
        public int firstMissingPositive(int[] nums) {

            //0 1 2
            //1 2 0
            //y y n
            //perfect position -> if i+1 = number
            int n  = nums.length;
            for(int i = 0 ; i < n ;){

                if(nums[i]<=0 || nums[i] > n)
                    i++;
                else if(i+1==nums[i])
                    i++;
                else if(nums[nums[i]-1]!=nums[i])
                    swap(nums,i,nums[i]-1);
                else i++;
            }
            int i = 0;
            for(i = 0 ; i < n ; i++){
                if(i+1!=nums[i]){
                    break;
                }
            }

            return i>0?i+1:1;

        }

        public void swap(int[] nums, int i ,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
