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
			int result = Integer.MAX_VALUE;
			int[] week = new int[7];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0;i < 7;i++) week[i] = Integer.parseInt(st.nextToken());
			
			for(int i = 0;i < 7;i++) {
				int day = N;
				int count = 0;
				int start = i;
				while(day != 0) {
					if(week[start] == 1) day--;
					count++;
					start++;
					if(start > 6) start = 0;
				}
				result = Math.min(result, count);
			}
			
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
