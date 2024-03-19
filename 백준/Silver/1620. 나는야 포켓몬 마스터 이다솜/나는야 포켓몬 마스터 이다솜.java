import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, String> hashMap = new HashMap<>();
        HashMap<String, Integer> hashMap1 = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int dic = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        for(int i = 1;i <= dic;i++){
            String name = br.readLine();
            hashMap.put(String.valueOf(i), name);
            hashMap1.put(name, i);
        }

        for(int i = 0;i < num;i++){
            String order = br.readLine();
            if(hashMap.containsKey(order)) bw.write(hashMap.get(order) + "\n");
            else if(hashMap1.containsKey(order)) bw.write(hashMap1.get(order) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
