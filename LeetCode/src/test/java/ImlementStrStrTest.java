import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImlementStrStrTest {

    @Test
    public void testKMP(){

        Assert.assertEquals(ImlementStrStr.kmp(new String("aabaaabaaac"), "aabaaac"),4);
    }

}