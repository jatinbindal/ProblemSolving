
import java.util.*;
public class HeapRunningOperations {
//operations like insert , delete and find min on heap
//https://www.hackerrank.com/challenges/qheap1/problem



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int[] heap = new int[100000];
        int count = 0;
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        sc.nextLine();

        while(q-- > 0){
            String result = sc.nextLine();
            Scanner resultScanner = new Scanner(result);
            Integer n;


            switch(Integer.parseInt(resultScanner.next())){
                case 1 :
                    n = Integer.parseInt(resultScanner.next());
                    heap[count] = n;
                    rise(heap,count);
                    count++;


                    break;
                case 2 :
                    n = Integer.parseInt(resultScanner.next());

                    for(int i = 0 ; i < count ; i++){

                        if(heap[i] == n){

                            swap(heap, i, count-1);
                            count--;
                            sink(heap,i,count-1);
                            break;
                        }

                    }

                case 3 :
                    System.out.println(heap[0]);
                    break;

            }

        }
    }

    static void swap(int[] nums , int i , int j ){
        int temp  = nums[i];
        nums[i] = nums[j];
        nums[j]  = temp;
    }

    static void rise(int[] heap, int index){
        while(index > 0){
            if(heap[index] < heap[(index-1)/2]){
                swap(heap,index, (index-1)/2);
                index = (index-1)/2;
            }
            else
                break;
        }
    }

    static void sink(int[] heap, int index, int max ){
        int left = 2*index + 1;
        int right = 2*index + 2;
        int smallest = index;
        if(left <= max && heap[smallest] > heap[left]) smallest = left;
        if(right <= max && heap[smallest] > heap[right]) smallest = right;


        if(smallest!=index){
            swap(heap,smallest,index);
            sink(heap,smallest,max);
        }

    }

    static void  print(int[] heap , int max){
        for(int i = 0 ; i <= max ; i++)
            System.out.print(heap[i] + " ");
        System.out.println();
    }
}
