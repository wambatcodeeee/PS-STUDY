import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            hashMap.putIfAbsent(day, new ArrayList<>());
            hashMap.get(day).add(score);
        }

        int result = 0;
        int maxDay = 0;

        for(int day : hashMap.keySet()){
            maxDay = Math.max(maxDay, day);
        }

        for(int day = maxDay; day > 0; day--){
            if(hashMap.containsKey(day)) queue.addAll(hashMap.get(day));
            if(!queue.isEmpty()) result += queue.poll();
        }

        System.out.println(result);
    }
}
