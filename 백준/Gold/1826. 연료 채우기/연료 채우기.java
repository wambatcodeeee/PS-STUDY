import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[][] station = new int[num][2];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            station[i][0] = Integer.parseInt(st.nextToken());
            station[i][1] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        Arrays.sort(station, Comparator.comparingInt(a -> a[0]));

        int stopCount = 0;
        int current = P;
        int index = 0;

        for(int i = 0; i < L; i++){
            while(index < num && station[index][0] <= current){
                queue.offer(station[index][1]);
                index++;
            }

            if(current >= L) break;
            if(queue.isEmpty()){
                stopCount = -1;
                break;
            }

            current += queue.poll();
            stopCount++;
        }

        System.out.println(stopCount);
    }
}
