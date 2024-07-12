import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] start = new int[num];
        int[] end = new int[num];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            start[i] = Integer.parseInt(st.nextToken());
            end[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int room = 0;
        int index = 0;

        for(int i = 0; i < num; i++){
            if(start[i] < end[index]) room++;
            else index++;
        }

        bw.write(String.valueOf(room));
        bw.flush();
        bw.close();
        br.close();
    }
}
