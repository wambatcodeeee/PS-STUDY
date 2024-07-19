import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int num = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int height = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek() > height){
                stack.pop();
                count++;
            }

            if(stack.isEmpty() || stack.peek() < height) stack.push(height);
        }

        while(!stack.isEmpty()){
            if(stack.pop() > 0) count++;
        }
        System.out.println(count);
    }
}
