import java.io.*;
import java.util.*;

class CupRamen implements Comparable<CupRamen>{
    long deadLine;
    long amount;

    public CupRamen(long deadLine, long amount){
        this.deadLine = deadLine;
        this.amount = amount;
    }

    @Override
    public int compareTo(CupRamen o){
        if(this.deadLine != o.deadLine) return Long.compare(this.deadLine, o.deadLine);
        else return Long.compare(o.amount, this.amount);
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Long> pq = new PriorityQueue<>();
    static CupRamen[] array;
    static long result = 0;

    public static void solution() throws IOException {
        for(CupRamen c : array){
            pq.add(c.amount);
            if(pq.size() > c.deadLine) pq.poll();
        }

        while(!pq.isEmpty()){
            result += pq.poll();
        }
    }


    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        array = new CupRamen[num];

        for(int i = 0;i < num;i++){
            st = new StringTokenizer(br.readLine());
            array[i] = new CupRamen(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        Arrays.sort(array);
        solution();

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}