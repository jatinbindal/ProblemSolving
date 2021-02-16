package leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if(strs.length==0) return "";
        char c;
        StringBuilder lcp = new StringBuilder();
        int i = 0;
        while(i<strs[0].length()){
            c = strs[0].charAt(i);
            int j = 1;
            for(; j < strs.length && i < strs[j].length(); j++) {
                if (strs[j].charAt(i) != c) {
                    break;
                }
            }
                if(j!=strs.length) return lcp.toString();
                lcp.append(c);
                i++;

            }


 return lcp.toString();
    }
}
