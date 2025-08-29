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
            int c1 = this.x - o.x;
            if(c1 != 0) return c1;
            else return this.y - o.y;
        }
    }

    public static void solution(ArrayList<Coordinate> arrayList) throws IOException {
        Collections.sort(arrayList);
        int start = arrayList.get(0).x, end = arrayList.get(0).y;
        int result = end - start;

        for(int i = 1;i < arrayList.size();i++){
            if(arrayList.get(i).x > end) {
                start = arrayList.get(i).x;
                end = arrayList.get(i).y;
                result += end - start;
            }
            if(arrayList.get(i).x <= end) {
                if(arrayList.get(i).y > end){
                    result += arrayList.get(i).y - end;
                    end = arrayList.get(i).y;
                }
            }
        }

        bw.write(String.valueOf(result));
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