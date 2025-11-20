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
			int[] dp = new int[N];
			int result = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i < N;i++) array[i] = Integer.parseInt(st.nextToken());
			
			dp[0] = array[0];
			if(N != 1) for(int i = 1;i < N;i++) dp[i] = Math.max(array[i], dp[i - 1] + array[i]);
			for(int i : dp) if(i > result) result = i;
			
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}