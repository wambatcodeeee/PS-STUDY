import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        Deque<int[]> deque = new ArrayDeque<>();

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] heightArray = new int[num];
        int[] resultArray = new int[num];

        for(int i = 0; i < num; i++){
            heightArray[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < num; i++){
            int current = heightArray[i];

            while(!deque.isEmpty() && deque.peek()[1] <= current){
                deque.pop();
            }

            if(!deque.isEmpty()) resultArray[i] = deque.peek()[0] + 1;
            else resultArray[i] = 0;

            deque.push(new int[]{i, current});
        }

        for(int i = 0; i < num; i++){
            sb.append(resultArray[i]).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
