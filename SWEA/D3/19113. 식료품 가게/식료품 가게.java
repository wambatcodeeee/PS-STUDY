import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for(int t = 1;t <= testCase;t++){
            sb.append("#").append(t).append(" ");
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] array = new int[N * 2];
            ArrayList<Integer> resultArray = new ArrayList<>();
            for(int i = 0;i < N * 2;i++) array[i] = Integer.parseInt(st.nextToken());

            for(int i = 0;i < N * 2 - 1;i++){
                for(int j = i;j < N * 2;j++){
                    if(array[i] / 0.75 == array[j] && array[i] != 0){
                        resultArray.add(array[i]);
                        array[j] = 0;
                        break;
                    }
                }
            }
            
            for(int i : resultArray) sb.append(i).append(" ");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}