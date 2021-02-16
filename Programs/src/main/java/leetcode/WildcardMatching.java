package leetcode;

public class WildcardMatching {

        Boolean[][] flag;
        public boolean isMatch(String s, String p) {
            flag = new Boolean[s.length()][p.length()];
            return match(s,p,0,0);

        }
        public boolean match(String s , String p, int i, int j){

            if(i == s.length() && (j == p.length() || allStar(p,j)))
                return true;

            if(j == p.length() || i == s.length())
                return false;

            char sChar = s.charAt(i);;
            char pChar = p.charAt(j);

            if(sChar == pChar || pChar == '?'){
                if(flag[i][j]==null)
                    flag[i][j] = match(s,p,i+1,j+1);
                return flag[i][j];

            }
            if(pChar =='*'){
                while(j+1 < p.length() && p.charAt(j+1) =='*')
                    j++;
                if(j+1 == p.length())
                    return true;
                for(int ind = i ; ind < s.length() ; ind++){
                    if(flag[ind][j]==null)
                        flag[ind][j] = match(s,p,ind,j+1);
                    if(flag[ind][j])
                        return true;
                }
            }
            return false;
        }

        public boolean allStar(String p , int ind){
            for(int i = ind ; i < p.length() ; i++){
                if(p.charAt(i)!='*')
                    return false;
            }
            return true;
        }
    }

