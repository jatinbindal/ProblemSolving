public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int p1 = 0;
        int p2 = 0;
        while(p1<nums.length && p2<nums.length){
            while(p1<nums.length && (nums[p1]!=0 && nums[p1]!=Integer.MIN_VALUE)){
                p1++;
            }

            p2 = p2>p1+1?p2:p1+1;
            while(p2<nums.length && (nums[p2]==0||nums[p2]==Integer.MIN_VALUE)){
                p2++;
            }

            if(p2<nums.length){
                nums[p1] = nums[p2];
                nums[p2] =Integer.MIN_VALUE;
                p1++;
                p2++;
            }
        }
        while(p1<nums.length){
            nums[p1++] = 0;

    }
}
}
