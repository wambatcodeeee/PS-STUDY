import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            ArrayList<Integer> valueArray = hashMap.getOrDefault(key, new ArrayList<>());
            valueArray.add(value);
            hashMap.put(key, valueArray);
        }

        ArrayList<Integer> keySet = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySet);

        for(int i : keySet){
            ArrayList<Integer> values = hashMap.get(i);
            Collections.sort(values);
            for(int j : values){
                sb.append(i).append(" ").append(j).append("\n");
            }
        }

        System.out.print(sb);
        br.close();
    }
}