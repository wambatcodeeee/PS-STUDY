import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        long division = 1000000007;
        int caseNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < caseNum; i++){
            PriorityQueue<Long> queue = new PriorityQueue<>();
            int num = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for(int n = 0; n < num; n++){
                queue.add(Long.parseLong(st.nextToken()));
            }

            long totalCost = 1;

            while(queue.size() > 1){
                long a = queue.poll();
                long b = queue.poll();
                long cost = (a * b) % division;
                totalCost = (totalCost * cost) % division;
                queue.add(a * b);
            }

            bw.write(totalCost + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
