import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean result = true;
        for(char c : s.toCharArray()){
            if(c == '(') stack.add(c);
            else {
                if(stack.isEmpty()) {
                    result = false;
                    break;
                } else stack.pop();
            }
        }
        
        return result && stack.isEmpty() ? true : false;
    }
}