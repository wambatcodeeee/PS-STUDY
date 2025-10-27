import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while(testCase-- > 0){
            int player = Integer.parseInt(br.readLine());
            char[] draft = new char[player + 1];
            int[] teamA = new int[player + 1];
            int[] teamB = new int[player + 1];

            st = new StringTokenizer(br.readLine());
            for(int i = 1;i <= player;i++) teamA[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 1;i <= player;i++) teamB[i] = Integer.parseInt(st.nextToken());

            while(true){
                boolean flag = true;

                for(int i = 1;i <= player;i++){
                    if(draft[teamA[i]] == 0){
                        draft[teamA[i]] = 'A';
                        break;
                    }
                }

                for(int i = 1;i <= player;i++){
                    if(draft[teamB[i]] == 0){
                        draft[teamB[i]] = 'B';
                        break;
                    }
                }

                for(int i = 1;i <= player;i++)
                    if (draft[i] == 0) {
                        flag = false;
                        break;
                    }
                if(flag) break;
            }

            for(int i = 1;i <= player;i++) sb.append(draft[i]);
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}