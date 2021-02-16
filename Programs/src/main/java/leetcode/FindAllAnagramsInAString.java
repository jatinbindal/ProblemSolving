package leetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {
     public List<Integer> findAnagrams(String s, String p) {

            List<Integer> result = new ArrayList();
            if(s.length()<p.length()) return result;
            int[] hash = new int[265];
            for(char ch : p.toCharArray())
                hash[ch]++;

            int window = p.length(),left = 0, right= 0,count = p.length();

            while(right<window){
                hash[s.charAt(right)]--;
                if(hash[s.charAt(right++)]>=0) count--;
            }
            if(count==0) result.add(left);
            while(right<s.length()){
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0) count++;
                left++;
                hash[s.charAt(right)]--;
                if(hash[s.charAt(right)] >=0 ) count--;
                if(count==0) result.add(left);
                right++;
                //System.out.println(count + " " +  s.charAt(left-1)+hash[s.charAt(left-1)] + " " + s.charAt(right-1)+hash[s.charAt(right-1)]);


            }
            return result;
        }


    }


