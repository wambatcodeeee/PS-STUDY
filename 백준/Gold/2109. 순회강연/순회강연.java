import java.util.*;
import java.io.*;

class Lecture implements Comparable<Lecture>{
    int pay;
    int day;

    public Lecture(int pay, int day){
        this.pay = pay;
        this.day = day;
    }

    @Override
    public int compareTo(Lecture o1){
        return this.day - o1.day;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        Lecture[] array = new Lecture[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int result = 0;

        for(int i = 0;i < N;i++) {
            st = new StringTokenizer(br.readLine());
            array[i] = new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        
        Arrays.sort(array);
        
        for(Lecture l : array){
            pq.add(l.pay);
            if(l.day < pq.size()) pq.poll();
        }

        while(!pq.isEmpty()) result += pq.poll();
        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}