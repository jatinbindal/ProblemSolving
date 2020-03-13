import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GroupAnagramsTest {

    @Test
    public void groupAnagramsTest(){
        String[] in = new String[]{"eat","tea","tan","ate","nat","bat"};
         GroupAnagrams.groupAnagrams(in);
        Assert.assertEquals(GroupAnagrams.groupAnagrams(in).size(),3);
    }


}