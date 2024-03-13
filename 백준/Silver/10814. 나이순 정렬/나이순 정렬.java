import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        LinkedHashMap<Integer, List<String>> linkedHashMap = new LinkedHashMap<>();
        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            String value = st.nextToken();

            List<String> valueArray;

            if(linkedHashMap.containsKey(key)){
                valueArray = linkedHashMap.get(key);
            }else{
                valueArray = new ArrayList<>();
            }
            valueArray.add(value);
            linkedHashMap.put(key, valueArray);
        }

        List<Integer> keyList = new ArrayList<>(linkedHashMap.keySet());
        Collections.sort(keyList);

        for(int i:keyList){
            for(String j:linkedHashMap.get(i)){
                bw.write(i + " " + j + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
