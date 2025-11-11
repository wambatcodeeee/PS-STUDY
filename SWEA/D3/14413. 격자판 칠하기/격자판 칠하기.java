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
			char[][] map = new char[N][M];
			
			for(int i = 0;i < N;i++) {
				String str = br.readLine();
				for(int j = 0;j < M;j++) map[i][j] = str.charAt(j);
			}
			
			boolean isDot = true;
			boolean isHash = true;
			
			for(int i = 0;i < N;i++) {
				for(int j = 0;j < M;j++) {
					char expectDot = (i + j) % 2 == 0 ? '.' : '#';
					char expectHash = (i + j) % 2 == 0 ? '#' : '.';
					
					if(map[i][j] != '?') {
						if(map[i][j] != expectDot) isDot = false;
						if(map[i][j] != expectHash) isHash = false;
					}
				}
			}
			
			if(isDot || isHash) sb.append("possible").append("\n");
			else sb.append("impossible").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}