import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int result = 0;

        for(int i = 0;i < N;i++){
            char[] chars = br.readLine().toCharArray();
            for(int j = 0;j < chars.length;j++){
                int current = (int) Math.pow(10, chars.length - 1 - j);
                hashMap.put(chars[j] - 'A', hashMap.getOrDefault(chars[j] - 'A', 0) + current);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(hashMap.keySet());
        keys.sort((a, b) -> hashMap.get(b) - hashMap.get(a));

        int currnetNum = 9;
        for(int i : keys){
            result += hashMap.get(i) * currnetNum;
            currnetNum--;
        }

        sb.append(result);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}