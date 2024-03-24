import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hashMap = new HashMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            String name = br.readLine();
            name = name.substring(name.indexOf(".") + 1);

            if(!hashMap.containsKey(name)) hashMap.put(name, 1);
            else hashMap.put(name, hashMap.get(name) + 1);
        }

        ArrayList<String> keySet = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySet);

        for(String s:keySet){
            sb.append(s).append(" ").append(hashMap.get(s)).append("\n");
        }

        System.out.print(sb);
    }
}
