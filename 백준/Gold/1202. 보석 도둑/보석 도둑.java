import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        ArrayList<HashMap<String, Integer>> jewelArray = new ArrayList<>();
        ArrayList<Integer> bagArray = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            HashMap<String, Integer> jewel = new HashMap<>();
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            jewel.put("weight", weight);
            jewel.put("value", value);
            jewelArray.add(jewel);
        }

        for(int i = 0; i < K; i++){
            bagArray.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewelArray, Comparator.comparingInt(j -> j.get("weight")));
        Collections.sort(bagArray);

        long result = 0;
        int index = 0;

        for(int i = 0; i < K; i++){
            while(index < N && jewelArray.get(index).get("weight") <= bagArray.get(i)){
                queue.add(jewelArray.get(index).get("value"));
                index++;
            }
            if(!queue.isEmpty()) result += queue.poll();
        }

        System.out.println(result);
    }
}
