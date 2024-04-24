import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hashMap = new HashMap<>();

        String input;
        int totalTrees = 0;

        while((input = br.readLine()) != null){
            if(!hashMap.containsKey(input)) hashMap.put(input, 1);
            else hashMap.put(input, hashMap.get(input) + 1);
            totalTrees++;
        }

        ArrayList<String> arrayList = new ArrayList<>(hashMap.keySet());
        Collections.sort(arrayList);

        for(String name:arrayList){
            sb.append(name).append(" ").append(String.format("%.4f", (double)(hashMap.get(name) * 100) / (double)totalTrees)).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
