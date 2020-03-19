import sun.jvm.hotspot.ui.EditableAtEndDocument;

import java.lang.reflect.InvocationTargetException;

public class DivideTwoIntegers {
        public int divide(int dividend, int divisor) {

            if(divisor == 1) return dividend;
            boolean factor = dividend < 0 != divisor < 0;
            if(dividend==Integer.MIN_VALUE){
                if(divisor == -1)
                return Integer.MAX_VALUE;
                else if(divisor == Integer.MAX_VALUE)
                    return -1;
            }
            dividend = Math.abs(dividend);
            divisor = Math.abs(divisor);
            int result = 0;
            while((dividend - divisor)>=0){
                dividend-=divisor;
                result++;
            }
            if(factor) {
                result = result - result - result;
            }
            return result;
        }

    }
