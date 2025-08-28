import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static class Coordinate implements Comparable<Coordinate>{
        int x;
        int y;

        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Coordinate o){
            int c1 = this.y - o.y;
            if(c1 != 0) return c1;
            else return this.x - o.x;
        }
    }

    public static void solution(ArrayList<Coordinate> arrayList) throws IOException {
        Collections.sort(arrayList);
        for(Coordinate c : arrayList){
            sb.append(c.x).append(" ").append(c.y).append("\n");
        }


        bw.write(String.valueOf(sb));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        ArrayList<Coordinate> arrayList = new ArrayList<>();

        for(int i = 0;i < num;i++){
            st = new StringTokenizer(br.readLine());
            arrayList.add(new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        solution(arrayList);
        bw.close();
        br.close();
    }
}