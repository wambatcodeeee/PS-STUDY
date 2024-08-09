import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int childNum = Integer.parseInt(st.nextToken());
        int teamNum = Integer.parseInt(st.nextToken());
        int[] heights = new int[childNum];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < childNum; i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int[] differenceArray = new int[childNum - 1];
        for(int i = 0; i < childNum - 1; i++){
            differenceArray[i] = heights[i + 1] - heights[i];
        }

        Arrays.sort(differenceArray);

        int result = 0;
        for(int i = 0; i < childNum - teamNum; i++){
            result += differenceArray[i];
        }

        System.out.println(result);
    }
}
