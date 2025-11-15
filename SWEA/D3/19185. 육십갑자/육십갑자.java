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
			int M = Integer.parseInt(st.nextToken());
			String[] nArray = new String[N + 1];
			String[] mArray = new String[M + 1];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 1;i <= N;i++) nArray[i] = st.nextToken();
			st = new StringTokenizer(br.readLine());
			for(int i = 1;i <= M;i++) mArray[i] = st.nextToken();
			
			int Q = Integer.parseInt(br.readLine());
			for(int i = 0;i < Q;i++) {
				int Y = Integer.parseInt(br.readLine());
				sb.append(nArray[Y % N == 0 ? N : Y % N]).append(mArray[Y % M == 0 ? M : Y % M]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}