import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, String> hashMap = new HashMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            String birth;
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String day = st.nextToken();
            if(day.length() == 1) day = "0" + day;
            String month = st.nextToken();
            if(month.length() == 1) month = "0" + month;
            String year = st.nextToken();

            birth = year + month + day;
            hashMap.put(birth, name);
        }

        ArrayList<String> keySet = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySet);

        bw.write(hashMap.get(keySet.get(keySet.size() - 1)) + "\n");
        bw.write(hashMap.get(keySet.get(0)));
        bw.flush();
        bw.close();
        br.close();
    }
}