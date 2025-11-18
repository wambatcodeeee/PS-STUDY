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
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			char[] X = st.nextToken().toCharArray();
			long result = 0;
			
			for(int i = 0;i < X.length;i++) result = (result + (X[i] - '0')) % (N - 1);
			sb.append(result).append("\n");
			
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}