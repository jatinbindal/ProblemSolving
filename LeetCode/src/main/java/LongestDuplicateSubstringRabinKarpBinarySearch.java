import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDuplicateSubstringRabinKarpBinarySearch {

        public String longestDupSubstring(String s) {

            int maxPos = s.length() - 1;
            int minPos = 1;
            int m = 100000007;
            long powers[] = new long[s.length()];
            powers[0] = 1;
            for(int i = 1 ; i < s.length(); i++)
                powers[i] = (powers[i-1]*26)%m;
            String ans = "";
            binary:
            while(minPos<=maxPos){
                int len = minPos + (maxPos-minPos)/2;
                //System.out.println(len);
                String p = s.substring(0,len);

                Map<Long,List<Integer>> map = new HashMap();
                long current = 0;
                for(char c : p.toCharArray()){
                    current = ((current * 26)+ (c - 'a')) % m;
                }
                List<Integer> list = new ArrayList();
                list.add(0);
                map.put(current,list);
                for(int j = 1 ; j<=s.length() - len ; j++){
                    //current = ((current-(long)powers[len-1]*(s.charAt(j-1)-'a'))%m+m) % m;
                    //current = (current*26+(s.charAt(j+len-1)-'a')) % m;
                    current=(current*26+(s.charAt(j+len-1)-'a')-((s.charAt(j-1)-'a')*powers[len]))%m;
                    if(current<0) current+=m;
                    List<Integer> got  = map.get(current);
                    if(got!=null){
                        p = s.substring(j,j+len);
                        for(int i : got){
                            if(p.equals(s.substring(i,i+len))){
                                ans = p;
                                minPos = len + 1;
                                continue binary;
                            }
                        }
                        got.add(j);

                    }
                    else{
                        list = new ArrayList();
                        list.add(j);
                        map.put(current,list);
                    }
                }

                maxPos = len - 1;
            }

            return ans;
        }
    }

