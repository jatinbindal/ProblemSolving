import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SearchInsertPositionTest {

    @Test
    public void testSearchInsertPosition(){
       Assert.assertEquals(SearchInsertPosition.searchInsert(new int[]{1,3},2),1);

    }
}