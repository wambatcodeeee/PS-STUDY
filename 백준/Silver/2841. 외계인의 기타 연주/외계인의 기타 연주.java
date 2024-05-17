import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        List<Stack<Integer>> stacks = new ArrayList<>(6);
        for(int i = 0; i < 6; i++){
            stacks.add(new Stack<>());
        }

        int count = 0;

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int stringNum = Integer.parseInt(st.nextToken()) - 1;
            int fretNum = Integer.parseInt(st.nextToken());

            Stack<Integer> currentStack = stacks.get(stringNum);

            while(!currentStack.isEmpty() && currentStack.peek() > fretNum){
                currentStack.pop();
                count++;
            }

            if(currentStack.isEmpty() || currentStack.peek() != fretNum){
                currentStack.push(fretNum);
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
