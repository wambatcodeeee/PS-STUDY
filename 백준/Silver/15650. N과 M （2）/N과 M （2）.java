import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int[] array;
    static int num, length;

    public static void DFS(int start, int level) {
        if(level == length) {
            for(int i : array){
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = start;i <= num;i++){
            array[level] = i;
            DFS(i + 1, level + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        length = Integer.parseInt(st.nextToken());
        array = new int[length];

        DFS(1, 0);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}