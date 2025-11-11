import java.util.*;
import java.io.*;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	public static boolean checkPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num);i++) if(num % i == 0) return false;
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1;t <= testCase;t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			int y = 2;
			int x = y + N;
			
			while(checkPrime(x) || checkPrime(y)) {
				x++;
				y++;
			}
			sb.append(x).append(" ").append(y).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
