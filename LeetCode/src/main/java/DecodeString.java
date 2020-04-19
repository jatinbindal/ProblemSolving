import java.util.Stack;

public class DecodeString {
    public static String decodeString(String s) {
        Stack<Integer> count = new Stack();
        Stack<StringBuilder> st = new Stack();

        int num = 0;
        st.push(new StringBuilder());
        int i =0;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c>='0'  && c<='9'){
                num = num*10 + c-'0';
            }
            else if(c=='['){
                StringBuilder sb = new StringBuilder();
                count.push(num);
                num = 0;
                st.push(sb);
            }
            else if(c==']'){
                int repeat = count.pop();
                StringBuilder toAppend = st.pop();
                StringBuilder res = new StringBuilder();
                while(repeat>0){
                    res.append(toAppend);
                    repeat--;

                }

                st.push(st.pop().append(res));

            }

            else{
                st.push(st.pop().append(c));
            }
            i++;
        }
        return st.pop().toString();
    }
}
