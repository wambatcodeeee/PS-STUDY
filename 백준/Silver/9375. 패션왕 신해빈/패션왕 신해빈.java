import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0;i < testCase;i++){
            HashMap<String, Integer> hashMap = new HashMap<>();
            int num = Integer.parseInt(br.readLine());
            for(int j = 0;j < num;j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String category = st.nextToken();
                if(!hashMap.containsKey(category)) hashMap.put(category, 1);
                else hashMap.put(category, hashMap.get(category) + 1);
            }

            int count = 1;

            for(int j:hashMap.values()){
                count *= j+1;
            }

            bw.write(count - 1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
