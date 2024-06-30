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
        Deque<Integer> deque = new ArrayDeque<>();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];
        int[] result = new int[num];
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = num - 1; i >= 0; i--){
            while(!deque.isEmpty() && deque.peek() <= array[i]){
                deque.pop();
            }
            if(deque.isEmpty()) result[i] = -1;
            else result[i] = deque.peek();
            deque.push(array[i]);
        }

        for(int i = 0; i < num; i++){
            bw.write(result[i] + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
