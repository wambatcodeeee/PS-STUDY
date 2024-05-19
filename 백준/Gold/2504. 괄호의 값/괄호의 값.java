import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static int calculate(String input) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> stack1 = new Stack<>();

        for(char c : input.toCharArray()){
            if(c == '(' || c == '['){
                stack.push(c);
                stack1.push(-1);
            }else{
                if(stack.isEmpty()) return 0;

                char openBracket = stack.pop();
                if((c == ')' && openBracket != '(') || (c == ']' && openBracket != '[')){
                    return 0;
                }

                int innerValue = 0;

                while(!stack1.isEmpty() && stack1.peek() != -1){
                    innerValue += stack1.pop();
                }

                if(stack1.isEmpty() || stack1.pop() != -1){
                    return 0;
                }

                if(c == ')'){
                    stack1.push(innerValue == 0 ? 2 : 2 * innerValue);
                }else if (c == ']'){
                    stack1.push(innerValue == 0 ? 3 : 3 * innerValue);
                }
            }
        }

        if(!stack.isEmpty()) return 0;

        int result = 0;

        while(!stack1.isEmpty()){
            int value = stack1.pop();
            if (value == -1) return 0;
            result += value;
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        int result = calculate(input);

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}