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
			int result = 0;
			
			for(int i = 0;i <= 2 * N;i++) {
				int x = i - N;
				for(int j = 0;j <= 2 * N;j++) {
					int y = j - N;
					if(Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(N, 2)) result++;
				}
			}
			
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}