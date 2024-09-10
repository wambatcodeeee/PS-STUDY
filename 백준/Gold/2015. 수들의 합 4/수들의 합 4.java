import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Long, Long> hashMap = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(st.nextToken());
        long[] array = new long[N];
        
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            array[i] = Long.parseLong(st.nextToken());
        }
        
        hashMap.put(0L, 1L);
        
        long result = 0;
        long sum = 0;

        for(int i = 0; i < N; i++){
            sum += array[i];
            if(hashMap.containsKey(sum - K)) result += hashMap.get(sum - K);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0L) + 1);
        }

        System.out.println(result);
    }
}
