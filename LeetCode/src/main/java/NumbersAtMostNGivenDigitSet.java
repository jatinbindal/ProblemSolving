import java.util.Arrays;

public class NumbersAtMostNGivenDigitSet {

        public int atMostNGivenDigitSet(String[] digits, int n) {

            int ans = 0;
            Arrays.sort(digits);
            char[] no = Integer.toString(n).toCharArray();
            int nDigits = no.length;
            int options = digits.length;
            int temp = 1;
            // for digits < nDigits  : all possibiliteis can be taken
            for(int i = 1 ; i < nDigits ; i++){
                temp = temp * options;
                ans+=temp;
            }
            int last = 0; // count for digits = no of digit in N

            for(int j = 0 ; j < digits.length ; j++){
                temp = calculate(0,no,digits,j);
                if(temp == 0) // since digits is sorted
                    break;
                last+=temp;
            }

            return ans + last;
        }
        public int calculate(int ind, char[] no,String[] digits, int curr){

            int ans = 0;
            if(no[ind] > digits[curr].charAt(0)){
                if(ind == no.length-1)
                    return 1;
                ans = (int)Math.pow(digits.length , no.length -ind -1);
            }
            else if(no[ind] < digits[curr].charAt(0)){

                ans =  0;
            }
            else{
                if(ind == no.length-1)
                    return 1;
                for(int i = 0 ; i< digits.length ; i++){
                    ans +=calculate(ind+1, no, digits, i);
                }
            }

            return ans;
        }
    }
