package leetcode;

public class ImplementStrStrRabinKarp {

        public int strStr(String haystack, String needle) {

            if(needle.length() == 0)
                return 0;
            if(haystack.length() < needle.length())
                return -1;
            RollingHash p = new RollingHash(needle , needle.length());
            RollingHash s = new RollingHash(haystack , needle.length());
            int i = 0;
            do {
                if(p.hash == s.hash)
                    return  i ;

                s.move();
                i++;
            }
            while(i <= haystack.length() - needle.length());

            return -1;
        }
    }

    class RollingHash {
        private static final int MOD = (int) Math.pow(10, 9) + 7;
        private static final int POW = 26;
        String s;
        int start;
        int end;
        int size;
        long hash;
        long[] powers;

        RollingHash(String s, int size) {

            this.s = s;
            start = 0;
            end = size - 1;
            this.size = size;
            powers = new long[size + 1];
            powers[0] = 1;
            for (int i = 1; i <= size; i++) {
                powers[i] = (powers[i - 1] * POW) % MOD;
            }
            hash = 0;
            for (int i = start; i < size; i++) {
                hash = ((hash * POW) + s.charAt(i)) % MOD;
            }

            //System.out.println(s + " " + start + end + size );
        }

        public void move() {
            if (end < s.length() - 1) {
                //System.out.println(s + " " + start + end + size );
                hash = (hash - s.charAt(start) * powers[size - 1] % MOD + MOD) % MOD;

                hash = (hash * POW % MOD) + s.charAt(end + 1) % MOD;
                start++;
                end++;
            }
        }

    }
