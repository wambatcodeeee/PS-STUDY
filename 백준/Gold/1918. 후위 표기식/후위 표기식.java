import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static int priority(char operator) {
        switch(operator){
            case '+':
                return 1;
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String infix = br.readLine();
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < infix.length(); i++){
            char c = infix.charAt(i);

            if(c >= 'A' && c <= 'Z'){
                postfix.append(c);
            }else if (c == '('){
                stack.push(c);
            }else if (c == ')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }else{
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                    postfix.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()){
            postfix.append(stack.pop());
        }

        bw.write(String.valueOf(postfix));
        bw.flush();
        bw.close();
        br.close();
    }
}
