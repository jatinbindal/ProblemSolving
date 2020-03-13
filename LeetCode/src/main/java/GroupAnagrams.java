import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        String sorted = new String();
        HashMap<String,List<String>> map = new HashMap<>();
        for (String s :
                strs) {
            sorted = value(s);
            if(map.get(sorted)!=null){
                map.get(sorted).add(s);
            }
            else{
                map.put(sorted,new ArrayList<>());
                map.get(sorted).add(s);
            }

        }
        List<List<String>> result = new ArrayList<>();
        map.values().forEach(e->result.add(e));
        return  result;
    }
    public static String value(String s){

        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
