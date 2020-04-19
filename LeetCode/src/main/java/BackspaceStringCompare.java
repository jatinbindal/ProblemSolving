public class BackspaceStringCompare {
        public static boolean backspaceCompare(String S, String T) {

            int i = S.length() - 1, j = T.length()-1;
            int skipS = 0, skipT = 0;

            while(i>=0 || j>=0 ){

                while(i>=0){
                    if(S.charAt(i)=='#') {
                        skipS++;i--;continue;
                    }
                    else if(skipS>0){
                        i--;skipS--;continue;
                    }
                    else               break;
                }


                while(j>=0){
                    if(T.charAt(j)=='#') {
                        skipT++;j--;continue;
                    }
                    else if(skipT>0){
                        j--;skipT--;continue;
                    }
                    else                 break;
                }

                if(i>=0 && j>=0){
                    if(S.charAt(i)!=T.charAt(j)) return false;
                }
                if((i>=0)!=(j>=0)) return false;

                i--;j--;

            }
            return true;



        }
    }




