import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(HashMap<Integer, Integer> hashMap, int mosquito) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>(hashMap.keySet());
        int sum = 0, max = 0;
        int res_start = 0, res_end = 0;
        boolean flag = false;
        Collections.sort(arrayList);

        for(int i : arrayList){
            sum += hashMap.get(i);

            if(sum > max) {
                max = sum;
                res_start = i;
                flag = true;
            } else if(sum < max && flag){
                res_end = i;
                flag = false;
            }
        }

        sb.append(max).append("\n").append(res_start).append(" ").append(res_end);
        bw.write(sb.toString());
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int mosquito = Integer.parseInt(br.readLine());

        for(int i = 0; i < mosquito; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            hashMap.put(start, hashMap.getOrDefault(start, 0) + 1);
            hashMap.put(end, hashMap.getOrDefault(end, 0) - 1);
        }

        solution(hashMap, mosquito);
        bw.close();
        br.close();
    }
}