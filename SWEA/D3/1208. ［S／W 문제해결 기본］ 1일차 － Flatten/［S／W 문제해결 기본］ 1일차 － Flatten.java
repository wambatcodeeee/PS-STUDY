import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = 10;

        while(testCase-- > 0){
            int dump = Integer.parseInt(br.readLine());
            int[] box = new int[100];
            int result;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++) box[i] = Integer.parseInt(st.nextToken());

            while(dump-- > 0){
                int minIndex = 0, maxIndex = 0;

                for(int i = 0;i < 100;i++){
                    if(box[i] < box[minIndex]) minIndex = i;
                    if(box[i] > box[maxIndex]) maxIndex = i;
                }

                box[minIndex]++;
                box[maxIndex]--;

                max = box[maxIndex];
                min = box[minIndex];
            }

           	Arrays.sort(box);
            result = box[99] - box[0];
            sb.append("#").append(10 - testCase).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}