import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> count = new HashMap<>();

        for(int i = 0; i < N; i++){
            String word = br.readLine().trim();
            if(word.length() >= M){
                count.put(word, count.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<String> arrayList = new ArrayList<>(count.keySet());

        arrayList.sort((n1, n2) -> {
            int comp = Integer.compare(count.get(n2), count.get(n1));
            if(comp != 0){
                return comp;
            }

            int lengthComp = Integer.compare(n2.length(), n1.length());

            if (lengthComp != 0){
                return lengthComp;
            }
            return n1.compareTo(n2);
        });

        for(String word : arrayList){
            sb.append(word).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
