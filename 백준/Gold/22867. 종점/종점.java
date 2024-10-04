import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static long parsing(String time) {
        StringTokenizer st = new StringTokenizer(time, ":.");
        long hour = Long.parseLong(st.nextToken());
        long minute = Long.parseLong(st.nextToken());
        long second = Long.parseLong(st.nextToken());
        long milli = Long.parseLong(st.nextToken());

        return (hour * 3600000) + (minute * 60000) + (second * 1000) + milli;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long[][] bus = new long[num * 2][2];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            bus[i * 2][0] = parsing(st.nextToken());
            bus[i * 2][1] = 1;

            bus[i * 2 + 1][0] = parsing(st.nextToken());
            bus[i * 2 + 1][1] = -1;
        }

        Arrays.sort(bus, (a, b) -> {
            if(a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });

        int current = 0;
        int max = 0;

        for(long[] b : bus){
            current += b[1] == 1 ? 1 : -1;
            max = Math.max(max, current);
        }

        System.out.println(max);
    }
}
