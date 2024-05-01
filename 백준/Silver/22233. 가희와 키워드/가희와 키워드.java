import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> hashMap = new HashMap<>();

        int keyword = Integer.parseInt(st.nextToken());
        int memo = Integer.parseInt(st.nextToken());

        for (int i = 0; i < keyword; i++) {
            hashMap.put(br.readLine(), 1);
        }

        for (int i = 0; i < memo; i++) {
            st = new StringTokenizer(br.readLine(), ",");

            while(st.hasMoreTokens()) {
                String word = st.nextToken();
                hashMap.remove(word);
            }

            bw.write(hashMap.size() + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}