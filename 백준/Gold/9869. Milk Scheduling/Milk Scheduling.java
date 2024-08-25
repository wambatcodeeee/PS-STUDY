import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        ArrayList<int[]> arrayList = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int gallon = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            arrayList.add(new int[]{gallon, deadline});
        }

        arrayList.sort(Comparator.comparingInt(a -> a[1]));

        int result = 0;

        for(int[] cow : arrayList){
            int gallon = cow[0];
            int deadline = cow[1];

            queue.add(gallon);
            result += gallon;

            if(queue.size() > deadline) result -= queue.poll();
        }

        System.out.println(result);
    }
}
