import org.junit.Test;

import static org.junit.Assert.*;

public class BackspaceStringCompareTest {
    @Test
    public void backspaceStringCompare(){

        assertEquals(BackspaceStringCompare.backspaceCompare("ab#c","ad#c"),true);

    }

    private void assertEquals(boolean backspaceCompare, boolean b) {
    }

}