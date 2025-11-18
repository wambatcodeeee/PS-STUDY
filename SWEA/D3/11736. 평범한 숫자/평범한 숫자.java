import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException{
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1;t <= testCase;t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int[] array = new int[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());
			int count = 0;
			
			for(int i = 1;i < N - 1;i++)  if(!(array[i] < array[i - 1] && array[i] < array[i + 1]) && !(array[i] > array[i - 1] && array[i] > array[i + 1])) count++;
			
			sb.append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}