import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        String[] columns = new String[c];
        Arrays.fill(columns, "");

        for(int i = 0; i < r; i++){
            String row = br.readLine();
            
            for(int j = 0; j < c; j++){
                columns[j] += row.charAt(j);
            }
        }

        int count = 0;

        while(true){
            Set<String> set = new HashSet<>(Arrays.asList(columns));
            if (set.size() < c) break;
            count++;
            for(int i = 0; i < c; i++){
                columns[i] = columns[i].substring(1);
            }
        }
        System.out.println(count - 1);
    }
}
