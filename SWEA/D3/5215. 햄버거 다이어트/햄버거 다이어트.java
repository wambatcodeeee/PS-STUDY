import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, L, result;
    static int[] scoreArray, calorieArray;

    public static void DFS(int level, int score, int calorie){
        if(calorie > L) return;
        if(level == N) result = Math.max(result, score);
        else {
            DFS(level + 1, score + scoreArray[level], calorie + calorieArray[level]);
            DFS(level + 1, score, calorie);
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int test = 0;

        while(testCase-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            scoreArray = new int[N];
            calorieArray = new int[N];
            result = 0;

            for(int i = 0;i < N;i++){
                st = new StringTokenizer(br.readLine());
                scoreArray[i] = Integer.parseInt(st.nextToken());
                calorieArray[i] = Integer.parseInt(st.nextToken());
            }

            DFS(0, 0, 0);
            test++;

            sb.append("#").append(test).append(" ").append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}