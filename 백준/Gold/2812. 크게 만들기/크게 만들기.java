import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String number = br.readLine();
        int count = k;

        for(char numChar : number.toCharArray()){
            while(!stack.isEmpty() && stack.peek() < numChar && count > 0){
                stack.pop();
                count--;
            }
            stack.push(numChar);
        }

        while(count > 0){
            stack.pop();
            count--;
        }

        for(char c : stack){
            sb.append(c);
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
