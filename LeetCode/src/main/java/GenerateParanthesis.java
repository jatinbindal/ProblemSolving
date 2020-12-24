import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

        public List<String> generateParenthesis(int n) {

            List<String> res = new ArrayList();
            calculate(0,0,n,new StringBuilder(),res);
            return res;

        }
        public void calculate(int open, int close, int n,StringBuilder s,List<String> res ){
            if(s.length()==n*2){
                res.add(s.toString());
                return;
            }

            if(open<n){
                calculate(open+1,close,n,s.append('('),res);
                s.deleteCharAt(s.length()-1);
            }
            if(close<open){
                calculate(open,close+1,n,s.append(')'),res);
                s.deleteCharAt(s.length()-1);
            }

        }
    }

