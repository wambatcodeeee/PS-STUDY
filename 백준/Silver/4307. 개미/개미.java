import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            int ant = Integer.parseInt(st.nextToken());

            int fastest = 0;
            int latest = 0;

            for(int n = 0; n < ant; n++){
                int position = Integer.parseInt(br.readLine());
                int left = position;
                int right = length - position;

                fastest = Math.max(fastest, Math.min(left, right));
                latest = Math.max(latest, Math.max(left, right));
            }

            System.out.println(fastest + " " + latest);
        }
    }
}
