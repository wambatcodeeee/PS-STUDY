import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        String answer = "";
        for(int i = 0;i < number.length();i++){
            int current = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && k > 0 && current > stack.peek()){
                stack.pop();
                k--;
            }
            
            stack.push(current);
        }
        
        while(!stack.isEmpty() && k --> 0){
            stack.pop();
        }
        
        for(int i : stack) answer += i;
        
        return answer;
    }
}