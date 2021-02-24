package leetcode;

import java.util.Stack;

public class ScoreOfParanthesis {

        public int scoreOfParentheses(String S) {
            Stack<Integer> stack = new Stack<>();
            for(char c : S.toCharArray()){
                if(c == '(')
                    stack.push(0);
                else{
                    int temp = 0;
                    while(stack.peek()!=0){
                        temp += stack.pop();
                    }
                    stack.pop();
                    if(temp != 0)
                        stack.push(temp*2);
                    else
                        stack.push(temp+1);
                }
            }

            int result = 0;
            while(!stack.isEmpty())
                result += stack.pop();

            return result;
        }



    }

