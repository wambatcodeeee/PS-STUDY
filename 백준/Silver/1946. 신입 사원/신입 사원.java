import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++){
            int num = Integer.parseInt(br.readLine());
            int[][] person = new int[num][2];

            for(int n = 0; n < num; n++){
                st = new StringTokenizer(br.readLine());
                person[n][0] = Integer.parseInt(st.nextToken());
                person[n][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(person, Comparator.comparingInt(a -> a[0]));

            int result = 0;
            int minRank = Integer.MAX_VALUE;

            for(int n = 0; n < num; n++){
                int rank = person[n][1];
                
                if(rank < minRank){
                    result++;
                    minRank = rank;
                }
            }

            bw.write(result + "\n");
        }
        
        bw.flush();
        bw.close();
        br.close();
    }
}
