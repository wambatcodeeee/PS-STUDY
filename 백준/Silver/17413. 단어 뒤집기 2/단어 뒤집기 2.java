import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        boolean flag = false;
        char[] chrArray = str.toCharArray();

        for(char c:chrArray){
            if(c == '<'){
                flag = true;
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(c);
            } else if(c == '>'){
                flag = false;
                sb.append(c);
            } else if(!flag){
                if(c == ' '){
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                }else{
                    stack.push(c);
                }
            } else {
                sb.append(c);
            }
        }

        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}