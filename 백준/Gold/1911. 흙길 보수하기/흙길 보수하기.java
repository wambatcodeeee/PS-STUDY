import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[][] pond = new int[num][2];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            pond[i][0] = Integer.parseInt(st.nextToken());
            pond[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(pond, Comparator.comparingInt(a -> a[0]));

        int result = 0;
        int current = 0;

        for(int i = 0; i < num; i++){
            int start = pond[i][0];
            int end = pond[i][1];

            if(current < start) current = start;

            while(current < end){
                current += length;
                result++;
            }
        }

        System.out.println(result);
    }
}
