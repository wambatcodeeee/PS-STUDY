import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static ArrayList<Integer> pocketArray;
    static int N, K, result;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            pocketArray = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < N;i++) pocketArray.add(Integer.parseInt(st.nextToken()));
            pocketArray.sort(Collections.reverseOrder());
            result = pocketArray.get(0) - pocketArray.get(K - 1);

            for(int i = 0;i < N;i++) if(i + K - 1 < N) result = Math.min(pocketArray.get(i) - pocketArray.get(i + K - 1), result);
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}