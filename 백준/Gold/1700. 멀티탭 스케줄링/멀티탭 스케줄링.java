import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int holes = Integer.parseInt(st.nextToken());
        int appliances = Integer.parseInt(st.nextToken());

        int[] schedule = new int[appliances];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < appliances; i++){
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;

        for(int i = 0; i < appliances; i++){
            int current = schedule[i];
            int unplug = Integer.MIN_VALUE;
            int latest = Integer.MIN_VALUE;

            if(arrayList.contains(current)) continue;

            if(arrayList.size() < holes){
                arrayList.add(current);
                continue;
            }

            for(int n = 0; n < arrayList.size(); n++) {
                int device = arrayList.get(n);
                int next = 0;

                for(int m = i + 1; m < appliances; m++){
                    if(schedule[m] == device) break;
                    next++;
                }

                if(next > latest){
                    latest = next;
                    unplug = n;
                }
            }

            arrayList.remove(unplug);
            arrayList.add(current);
            result++;
        }

        System.out.println(result);
    }
}
