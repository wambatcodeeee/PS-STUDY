import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashMap = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = new int[N];

        for(int i = 0; i < N; i++){
            hashMap.put(br.readLine(), i);
        }

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            arr[i] = hashMap.get(name);
        }

        for(int i = 0; i < N - 1; i++){
            for(int j = i + 1; j < N; j++){
                if(arr[i] > arr[j]){
                    count += 1;
                    break;
                }
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
