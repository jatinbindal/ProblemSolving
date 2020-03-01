import org.junit.Assert;
import org.junit.Test;

public class ContainerWithMostWaterTest {

    @Test
    public void maxAreaTest() {
        Assert.assertEquals(ContainerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}),49);
    }
}