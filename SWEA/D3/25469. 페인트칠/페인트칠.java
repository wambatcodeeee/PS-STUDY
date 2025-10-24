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
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            char[][] array = new char[height][width];
            boolean flag = true;
            int result = 0;

            for(int i = 0;i < height;i++){
                String str = br.readLine();
                for(int j = 0;j < width;j++) {
                    array[i][j] = str.charAt(j);
                    if(array[i][j] == '.') flag = false;
                }
            }

            int row = 0;
            for(int i = 0;i < height;i++){
                boolean flag1 = true;
                for(int j = 0;j < width;j++)
                    if (array[i][j] == '.') {
                        flag1 = false;
                        break;
                    }
                if(flag1) row++;
            }

            int col = 0;
            for(int i = 0;i < width;i++){
                boolean flag1 = true;
                for(int j = 0;j < height;j++)
                    if (array[j][i] == '.') {
                        flag1 = false;
                        break;
                    }
                if(flag1) col++;
            }

            result = flag ? Math.min(row, col) : row + col;
            sb.append(result).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}