package leetcode;

class HeapSort {

    //max Heap
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        for(int i = n/2 - 1 ; i>=0 ; i--)
            heapify(nums,i,n);

        for (int i = n - 1; i >= 0; i--) {
            swap(nums,i,0);
            heapify(nums,0,i);
        }
        return nums;
    }

    public void heapify(int[] a , int root, int size){
        int left = 2*root + 1;
        int right = 2*root + 2;
        int largest = root;
        if(left < size && a[largest] < a[left]) largest = left;
        if(right < size && a[largest] < a[right]) largest = right;


        if(largest!=root){
            swap(a,largest,root);
            heapify(a,largest,size);
        }
    }

    public void swap(int[] a, int i , int j ){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}