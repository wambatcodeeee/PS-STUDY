import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[][] array = new int[num][num];

        for(int i = 0;i < num;i++){
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0;i < num;i++){
            int rank = 1;

            for(int j = 0;j < num;j++){
                if(array[i][0] < array[j][0] && array[i][1] < array[j][1]) {
                    rank++;
                }
            }

            bw.write(rank + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
