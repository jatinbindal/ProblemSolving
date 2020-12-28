public class InterleavingString {

        public boolean isInterleaveDP(String s1, int i, String s2, int j, String s3, int k, Boolean[][] memo) {
            if(i == s1.length()) {
                return s2.substring(j).equals(s3.substring(k));
            }
            if(j == s2.length()) {
                return s1.substring(i).equals(s3.substring(k));
            }
            if(memo[i][j] !=null) {
                return memo[i][j];
            }

            boolean ans = false;
            if(s3.charAt(k) == s1.charAt(i) && isInterleaveDP(s1, i+1, s2, j, s3, k+1, memo) || s3.charAt(k) == s2.charAt(j) && isInterleaveDP(s1, i, s2, j+1, s3, k+1, memo)) {
                ans = true;
            }
            memo[i][j] = ans ;
            return ans;
        }

        public boolean isInterleave(String s1, String s2, String s3) {
            Boolean[][] memo = new Boolean[s1.length()][s2.length()];

            return isInterleaveDP(s1, 0, s2, 0, s3, 0, memo);
        }
    }