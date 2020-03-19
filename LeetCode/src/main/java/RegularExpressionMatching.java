import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpressionMatching {
            public boolean isMatch(String s, String p) {


                Pattern pattern = Pattern.compile(p);
                // create a matcher that will match the given input against this pattern
                Matcher matcher = pattern.matcher(s);
                return matcher.matches();



            }

    }

