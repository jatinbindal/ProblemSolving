import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumTest {
    @Test
    public void testThreeSum(){
        Assert.assertEquals(ThreeSumClosest.threeSumClosest(new int[]{-1,0,1,1,55},3),2)
        ;
    }
}