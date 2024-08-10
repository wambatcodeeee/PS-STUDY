import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int craneNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] craneArray = new Integer[craneNum];

        for(int i = 0; i < craneNum; i++){
            craneArray[i] = Integer.parseInt(st.nextToken());
        }

        int boxNum = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Integer[] boxArray = new Integer[boxNum];

        for(int i = 0; i < boxNum; i++){
            boxArray[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(craneArray, Collections.reverseOrder());
        Arrays.sort(boxArray, Collections.reverseOrder());

        int result = 0;

        if(craneArray[0] < boxArray[0]) System.out.println(-1);
        else{
            boolean[] visited = new boolean[boxNum];
            int moved = 0;

            while(moved < boxNum){
                int index = 0;
                for(int i = 0; i < craneNum; i++){
                    while(index < boxNum){
                        if(!visited[index] && craneArray[i] >= boxArray[index]){
                            visited[index] = true;
                            moved++;
                            break;
                        }
                        index++;
                    }
                }
                result++;
            }

            System.out.println(result);
        }
    }
}
