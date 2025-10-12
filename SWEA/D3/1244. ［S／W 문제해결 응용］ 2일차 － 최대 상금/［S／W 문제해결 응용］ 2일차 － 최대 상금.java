import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static char[] array;
    static int price, chance;
    static String result;

    public static void DFS(int L, int start){
        if(L == chance) {
            String str = new String(array);
            if(str.compareTo(result) > 0) result = str;
        }
        else {
            for(int i = start;i < array.length;i++){
                for(int j = i + 1;j < array.length;j++){
                    char temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;

                    DFS(L + 1, i);

                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while(testCase-- > 0){
            st = new StringTokenizer(br.readLine());
            price = Integer.parseInt(st.nextToken());
            chance = Integer.parseInt(st.nextToken());
            array = String.valueOf(price).toCharArray();
            result = "";

            DFS(0, 0);

            sb.append("#").append(level).append(" ").append(result).append("\n");
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}