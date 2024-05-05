import java.io.*;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<String, Integer> hashMap = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for(int i = 0; i < N; i++){
            String name = br.readLine();
            if(name.equals("ENTER")){
                hashMap.clear();
                continue;
            }

            if(!hashMap.containsKey(name)){
                hashMap.put(name, 1);
                count++;
            }
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
