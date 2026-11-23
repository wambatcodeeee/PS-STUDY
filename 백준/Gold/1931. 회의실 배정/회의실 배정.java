import java.util.*;
import java.io.*;

public class Main{
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  public static void main(String args[]) throws IOException{
    StringTokenizer st;
    int nums = Integer.parseInt(br.readLine());
    int[][] meetings = new int[nums][2];
    for(int i = 0;i < nums;i++){
      st = new StringTokenizer(br.readLine());
      meetings[i][0] = Integer.parseInt(st.nextToken());
      meetings[i][1] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(meetings, (a, b) -> {
      if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
      return Integer.compare(a[1], b[1]);
    });

    int count = 0;
    int last = 0;

    for(int i = 0;i < nums;i++){
      if(meetings[i][0] >= last){
        last = meetings[i][1];
        count++;
      }
    }

    bw.write(String.valueOf(count));
    bw.flush();
    bw.close();
  }
}
