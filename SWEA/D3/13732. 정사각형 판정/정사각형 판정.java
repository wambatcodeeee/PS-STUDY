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
			char[][] map = new char[N][N];
			boolean flag = false;
			boolean flag1 = true;
			
			for(int i = 0;i < N;i++) {
				String str = br.readLine();
				for(int j = 0;j < N;j++) map[i][j] = str.charAt(j);
			}
			
			int firstX = 0;
			int firstY = 0;
			
			outer: for(int i = 0;i < N;i++) {
				for(int j = 0;j < N;j++) {
					if(map[i][j] == '#') {
						firstY = i;
						firstX = j;
						flag = true;
						break outer;
					}
				}
			}
			
			if(!flag) {
				sb.append("no").append("\n");
				continue;
			}
			
			int lastX = firstX, lastY = firstY;
			for(int i = firstX;i < N;i++) {
				if(map[firstY][i] == '#') lastX = i;
				else break;
			}
			for(int i = firstY;i < N;i++) {
				if(map[i][firstX] == '#') lastY = i;
				else break;
			}
			
			int width = lastX - firstX + 1;
			int height = lastY - firstY + 1;
			
			if(width != height) {
				sb.append("no").append("\n");
				continue;
			}
			
			for(int i = firstY;i <= lastY;i++) {
				for(int j = firstX;j <= lastX;j++) {
					if(map[i][j] == '.') {
						flag1 = false;
						break;
					}
				}
			}
			
			
			for(int i = 0;i < N;i++) {
				for(int j = 0;j < N;j++) {
					if(!(i >= firstY && i <= lastY && j >= firstX && j <= lastX)) {
						if(map[i][j] == '#') {
							flag1 = false;
							break;
						}
					}
				}
			}
			
			if(flag1) sb.append("yes").append("\n");
			else sb.append("no").append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
