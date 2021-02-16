package leetcode;

public  class ImlementStrStr {

    public int strStr(String haystack, String needle) {

        if(needle.length()==0) return 0;
        int i = 0, i2 = 0, j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                i2 = i + 1;
                while (j < needle.length() && i2 < haystack.length()) {
                    if (haystack.charAt(i2) == needle.charAt(j)) {
                        j++;
                        i2++;
                    } else {

                        break;
                    }
                }
                if (j == needle.length()) return i;
                else {
                    i++;
                    j = 0;
                }
            }
            else i++;

        }


        return -1;
    }

    public static int kmp(String haystack, String needle){

        if(needle.length()==0) return 0;
        if(haystack.length()==0) return -1;
        int[] lps = new int[needle.length()];
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else 
            {
                if (len != 0) {
                    len = lps[len - 1];

                } else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
            i=0;
            int j=0;
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j==needle.length())
                    return i-j;
            }
            else{
                if(j!=0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }
        if(j<needle.length())
            return -1;
        return i-j;


    }


}
