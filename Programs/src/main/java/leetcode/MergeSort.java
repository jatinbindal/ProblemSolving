package leetcode;

class MergeSort {
    public int[] sortArray(int[] nums) {

        mergeSort(nums,0,nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] a, int l , int r){

        if(l<r){
            int m = (l+r)/2;
            mergeSort(a,l,m);
            mergeSort(a,m+1,r);
            merge(a,l,m,r);
        }

    }

    public void merge(int[] a, int l, int m ,int r){

        int[] left = new int[m-l+1];
        int[] right = new int[r-m];
        for(int i = 0 ; i < left.length ; i++)
            left[i] = a[l+i];
        for(int j = 0 ; j < right.length ; j++)
            right[j] = a[m+1+j];

        int k = l , i = 0 , j = 0;
        while(i<left.length && j<right.length){
            if(left[i]<right[j]){
                a[k++] = left[i++];
            }
            else{
                a[k++] = right[j++];
            }
        }

        while(i<left.length){
            a[k++] = left[i++];
        }
        while(j<right.length){
            a[k++] = right[j++];
        }

    }
}