import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(int[] array) throws IOException {
        int lp = 0, rp = 0;
        int result = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (rp < array.length) {
            hashMap.put(array[rp], hashMap.getOrDefault(array[rp], 0) + 1);

            while(hashMap.size() > 2){
                hashMap.put(array[lp], hashMap.get(array[lp]) - 1);
                if(hashMap.get(array[lp]) == 0) hashMap.remove(array[lp]);
                lp++;
            }

            result = Math.max(result, rp - lp + 1);
            rp++;
        }

        bw.write(String.valueOf(result));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];

        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < num;i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        solution(array);

        bw.close();
        br.close();
    }
}