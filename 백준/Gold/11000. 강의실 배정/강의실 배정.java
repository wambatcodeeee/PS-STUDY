import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int[][] lectures = new int[num][2];

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures[i][0] = Integer.parseInt(st.nextToken());
            lectures[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lectures, Comparator.comparingInt(a -> a[0]));

        int room = 0;
        int[] end = new int[num];

        for(int i = 0; i < num; i++){
            boolean flag = false;
            for(int j = 0; j < room; j++){
                if(lectures[i][0] >= end[j]){
                    end[j] = lectures[i][1];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                end[room++] = lectures[i][1];
            }
        }

        bw.write(String.valueOf(room));
        bw.flush();
        bw.close();
        br.close();
    }
}
