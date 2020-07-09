class CountSort {
    public int[] sortArray(int[] nums) {
        // O(n) time and O(max(max-min, n)) space
        //Store count of n in nums at count[n + min]
        int min = nums[0], max = nums[0];
        for(int i=0;i<nums.length;++i)
        {

            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int n = max - min + 1;
        int[] count = new int[n];
        for(int i=0;i<nums.length;++i)
        {
            int num=nums[i];
            int idx = num - min;
            ++count[idx];
        }
        int i = 0;
        int[] result = new int[nums.length];
        for (int k = 0; k < n; k++) {
            int c = count[k];
            int num  = k + min;
            while(c-->0) {
                result[i++] = num;
            }
        }

        return result;
    }
}