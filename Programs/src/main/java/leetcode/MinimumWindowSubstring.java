package leetcode;

class MinimumWindowSubstring {
        public String minWindow(String s, String t) {

            if (s == null || s.length() == 0) {
                return "";
            }
            int [] map = new int[128];

            for (int i = 0; i < t.length(); i++) {
                map[t.charAt(i)]++;
            }

            int count = 0;
            int minLen = Integer.MAX_VALUE;
            int minStart = -1;
            int minEnd = -1;

            int low = 0;
            int high = 0;
            for (high = 0; high < s.length(); high++) {

                if (map[s.charAt(high)] > 0) {
                    count++;
                }

                map[s.charAt(high)]--;

                if (count == t.length()) {
                    while (low < high && map[s.charAt(low)] < 0) {
                        map[s.charAt(low)]++;
                        low++;
                    }
                    if (minLen > high-low+1) {
                        minLen = high-low+1;
                        minStart = low;
                        minEnd = high+1;
                    }
                    map[s.charAt(low)]++;
                    low++;
                    count--;
                }
            }


            return minStart == -1? "": s.substring(minStart, minEnd);
        }
    }
