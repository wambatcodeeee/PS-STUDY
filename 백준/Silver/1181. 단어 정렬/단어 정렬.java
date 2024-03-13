import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, List<String>> hashMap = new HashMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            String value = br.readLine();
            int key = value.length();

            List<String> valueArray;

            if(hashMap.containsKey(key)){
                valueArray = hashMap.get(key);
            }else{
                valueArray = new ArrayList<>();
            }
            valueArray.add(value);
            hashMap.put(key, valueArray);
        }

        List<Integer> keyList = new ArrayList<>(hashMap.keySet());
        Collections.sort(keyList);
            for(int i:keyList){
                HashSet<String> hashSet = new HashSet<>(hashMap.get(i));
                hashMap.get(i).clear();
                hashMap.get(i).addAll(hashSet);
                Collections.sort(hashMap.get(i));
                for(String j:hashMap.get(i)){
                    bw.write(j + "\n");
                }
            }

        bw.flush();
        bw.close();
        br.close();
    }
}
