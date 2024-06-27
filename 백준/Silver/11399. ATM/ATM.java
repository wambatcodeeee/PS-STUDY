import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] timeArray = new int[num];
        int totalTime = 0;
        int currentTime = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < num; i++){
            timeArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(timeArray);

        for(int i = 0; i < num; i++){
            currentTime += timeArray[i];
            totalTime += currentTime;
        }

        bw.write(totalTime + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
