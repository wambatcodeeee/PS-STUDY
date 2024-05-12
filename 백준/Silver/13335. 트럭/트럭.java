import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int calculateTime(int num, int weight, int max, int[] weights) {
        Queue<Integer> queue = new ArrayDeque<>();
        int time = 0;
        int currentWeight = 0;

        for(int i = 0; i < num; i++){
            while(true){
                if(queue.size() == weight) currentWeight -= queue.poll();
                else{
                    if(currentWeight + weights[i] <= max){
                        queue.offer(weights[i]);
                        currentWeight += weights[i];
                        time++;
                        break;
                    }else{
                        queue.offer(0);
                        time++;
                    }
                }
            }
        }
        return time + weight;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int weight = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] weights = new int[num];

        for(int i = 0; i < num; i++){
            weights[i] = Integer.parseInt(st.nextToken());
        }

        int time = calculateTime(num, weight, max, weights);

        bw.write(time + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
