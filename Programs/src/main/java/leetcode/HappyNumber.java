package leetcode;

public class HappyNumber {

    //Like checking cycle in linkedlist
    public boolean isHappy(int n) {
        int p1 = calculate(n);
        int p2 = calculate(calculate(n));
        while(p1!=1 && p1!=p2){
            p1 = calculate(p1);
            p2 = calculate(calculate(p2));
        }
        return p1==1;
    }

    public int calculate(int n){
        int res = 0;
        while(n>0){
            int temp = n%10;
            res+=temp * temp ;
            n/=10;
        }

        return res;
    }


}
