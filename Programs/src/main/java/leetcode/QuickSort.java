package leetcode;

import java.util.Random;

class QuickSort {
    Random r = new Random();
    public int[] sortArray(int[] nums) {
        quickSort(nums,0,nums.length-1);
        return nums;
    }

    public void quickSort(int[] nums, int low, int high){

        if(low<high){
            //for random;
            //int key = r.nextInt(high - low + 1) + low;
            //swap(nums,key,high);
            int ind = partitionRightMostPivot(nums,low,high);
            quickSort(nums,low,ind-1);
            quickSort(nums,ind,high);
        }
    }

    public int partitionRightMostPivot(int[] a , int low, int high){
        //last element as pivot;       
        int pivot = a[high];
        int i = low - 1; //last element which is definitlely smaller than pivot
        for(int j = low ; j < high ; j++){
            if(a[j]<=pivot){
                i++;
                swap(a,i,j);
            }
        }
        i++;
        swap(a,i,high);
        return i;

    }

    public int partitionMidPivot(int[] nums, int left , int right){
        //midPivot
        int pivotTerm = nums[left + (right - left ) / 2];
        while (left <= right) {
            while (nums[left] < pivotTerm) {
                left++;
            }
            while (nums[right] > pivotTerm) {
                right--;
            }

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        return left;
    }


    public void swap(int[] a , int i, int j){
        if(i!=j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}