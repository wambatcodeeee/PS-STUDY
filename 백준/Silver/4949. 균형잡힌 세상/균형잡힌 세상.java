import java.io.*;
import java.util.Stack;

public class Main {
    public static String Validator(String str){
        Stack<Character> stack = new Stack<>();
        char[] chrArray = str.toCharArray();
        for(char c:chrArray){
            if(c == '(' || c == '['){
                stack.push(c);
            } else if(c == ')') {
                if(stack.isEmpty()) return "no";
                if(stack.peek() == '[') return "no";
                stack.pop();
            } else if(c == ']'){
                if(stack.isEmpty()) return "no";
                if(stack.peek() == '(') return "no";
                stack.pop();
            } else if(c == '.'){
                stack.push(c);
            }
        }
        return stack.size() == 1 && stack.peek().equals('.') ? "yes" : "no";
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            if(str.equals(".")) break;
            System.out.println(Validator(str + "\n"));
        }
    }
}
