import java.util.*;
import java.io.*;

public class Main{
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  public static void main(String args[]) throws IOException{
    int num = Integer.parseInt(br.readLine());
    Deque<int[]> deque = new ArrayDeque<>();
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] height = new int[num];
    int[] result = new int[num];

    for(int i = 0;i < num;i++) height[i] = Integer.parseInt(st.nextToken());
    for(int i = 0;i < num;i++){
      int current = height[i];

      while(!deque.isEmpty() && deque.peek()[0] <= current) deque.pop();

      if(!deque.isEmpty()) result[i] = deque.peek()[1] + 1;
      else result[i] = 0;

      deque.push(new int[]{height[i], i});
    }

    StringBuilder sb = new StringBuilder();
    for(int i : result) sb.append(i).append(" ");

    bw.write(String.valueOf(sb) + "\n");
    bw.flush();
    bw.close();
  }
}