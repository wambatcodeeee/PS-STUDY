import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();


    public static void solution(char[][] array, int col, int row) throws IOException {
        int result = Integer.MAX_VALUE;
        int x = 0, y = 0;

        while(y <= col - 8){
            int wrongBlack = 0;
            int wrongWhite = 0;

            for(int i = y;i < y + 8;i++){
                for(int j = x;j < x + 8;j++){
                    char current = array[i][j];

                    if((i + j) % 2 == 0) {
                        if(current == 'W') wrongBlack++;
                        else wrongWhite++;
                    }else {
                        if(current == 'W') wrongWhite++;
                        else wrongBlack++;
                    }
                }
            }

            result = Math.min(result, Math.min(wrongWhite, wrongBlack));

            if(x < row - 8) x++;
            else {
                y++;
                x = 0;
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int col = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        char[][] array = new char[col][row];

        for(int i = 0;i < col;i++){
            String str = br.readLine();
            char[] chars = str.toCharArray();
            for(int j = 0;j < row;j++){
                array[i][j] = chars[j];
            }
        }

        solution(array, col, row);

        bw.close();
        br.close();
    }
}