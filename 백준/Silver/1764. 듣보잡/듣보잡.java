import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hashMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int listen = Integer.parseInt(st.nextToken());
        int look = Integer.parseInt(st.nextToken());
        int result = 0;

        for(int i = 0;i < listen;i++){
            hashMap.put(br.readLine(), 1);
        }

        for(int i = 0;i < look;i++){
            String name = br.readLine();
            if(hashMap.containsKey(name)){
                hashMap.put(name, 2);
                result++;
            }
        }
        sb.append(result).append("\n");

        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList);
        
        for(String s:arrayList){
            if(hashMap.get(s) == 2){
                sb.append(s).append("\n");
            }
        }
        System.out.print(sb);
    }
}
