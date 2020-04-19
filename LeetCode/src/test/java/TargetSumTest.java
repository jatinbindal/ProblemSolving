import org.junit.Test;

import static org.junit.Assert.*;

public class TargetSumTest {

    @Test
    public void test(){
           assertEquals(TargetSum.findTargetSumWays(new int[]{1,0},1),2);
    }

}