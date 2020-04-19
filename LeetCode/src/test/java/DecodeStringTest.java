import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {

    @Test
    public void test(){
        Assert.assertEquals(DecodeString.decodeString(new String("3[a2[c]]")),new String("accaccacc"));
    }

}