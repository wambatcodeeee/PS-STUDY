import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sensor = Integer.parseInt(br.readLine());
        int center = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] sensorArray = new int[sensor];

        for(int i = 0; i < sensor; i++){
            sensorArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensorArray);

        int[] distance = new int[sensor - 1];
        for(int i = 0; i < sensor - 1; i++){
            distance[i] = sensorArray[i + 1] - sensorArray[i];
        }

        Arrays.sort(distance);

        int result = 0;
        
        for(int i = 0; i < sensor - center; i++){
            result += distance[i];
        }

        System.out.println(result);
    }
}
