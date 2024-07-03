import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deque<Integer> stack = new ArrayDeque<>();
        String formula = br.readLine();
        int result = 0;
        int current;

        for(int i = 0; i < formula.length(); i++){
            char c = formula.charAt(i);

            switch(c){
                case 'H':
                    current = 1;
                    stack.push(current);
                    break;

                case 'C':
                    current = 12;
                    stack.push(current);
                    break;

                case 'O':
                    current = 16;
                    stack.push(current);
                    break;

                case '(':
                    stack.push(-1);
                    break;

                case ')':
                    int sum = 0;
                    while(!stack.isEmpty() && stack.peek() != -1){
                        sum += stack.pop();
                    }
                    stack.pop();

                    int multi;

                    if(i + 1 < formula.length() && Character.isDigit(formula.charAt(i + 1))){
                        multi = formula.charAt(i + 1) - '0';
                        i++;
                    }else multi = 1;

                    stack.push(sum * multi);
                    break;

                default:
                    if(Character.isDigit(c)){
                        int number = c - '0';
                        int previous = stack.pop();
                        stack.push(previous * number);
                    }
                    break;
            }
        }

        while(!stack.isEmpty()){
            result += stack.pop();
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
