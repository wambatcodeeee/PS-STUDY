import java.util.*;
import java.io.*;

class dart{
	int x;
	int y;
	
	public dart(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] board = {20, 40, 60, 80, 100, 120, 140, 160, 180, 200};
	
	public static void main(String[] args) throws IOException{
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1;t <= testCase;t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int result = 0;
			dart[] array = new dart[N];
			
			for(int i = 0;i < N;i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				array[i] = new dart(x, y);
			}
			
			for(int i = 0;i < array.length;i++) {
				int x = array[i].x;
				int y = array[i].y;
				double z = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
				for(int j = 0;j < board.length;j++) {
					if(board[j] >= z) {
						result += 10 - j;
						break;
					}
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
