import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArray = array.clone();
        Arrays.sort(sortedArray);

        int rank = 0;

        for(int i = 0; i < num; i++){
            if(!hashMap.containsKey(sortedArray[i])){
                hashMap.put(sortedArray[i], rank);
                rank++;
            }
        }

        for(int i = 0; i < num; i++){
            sb.append(hashMap.get(array[i])).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
