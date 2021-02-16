package leetcode;

public class IntegerToEnglishWords {



        private final String[] belowTen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        private final String[] belowTwenty = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        private final String[] belowHundred = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};



        public String numberToWords(int num) {
            if (num == 0) return "Zero";
            return helper(num).toString().trim();
        }


        public StringBuilder helper(int num){

            StringBuilder result = new StringBuilder();
            if(num==0) return result;
            if(num < 10) {
                result.append(belowTen[num]);
                result.append(" ");
            }
            else if(num<20){
                result.append(belowTwenty[num-10]);
                result.append(" ");
            }
            else if(num<100) {
                result.append(belowHundred[num/10]);
                result.append(" ");
                result.append(helper(num%10));
            }
            else if(num<1000){
                result.append(helper(num/100));
                result.append("Hundred ");
                result.append(helper(num%100));
            }
            else if(num<1000000){
                result.append(helper(num/1000));
                result.append("Thousand ");
                result.append(helper(num%1000));
            }
            else if(num<1000000000){
                result.append(helper(num/1000000));
                result.append("Million ");
                result.append(helper(num%1000000));
            }
            else{
                result.append(helper(num/1000000000));
                result.append("Billion ");
                result.append(helper(num%1000000000));
            }

            return result;
        }
    }

