import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, String> login = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int site = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        for(int i = 0;i < site;i++){
            st = new StringTokenizer(br.readLine());
            login.put(st.nextToken(), st.nextToken());
        }

        for(int i = 0;i < target;i++){
            bw.write(login.get(br.readLine()) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
