import java.util.*;
import java.io.*;
import java.math.BigInteger;

public class Solution {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] array = {1, 0, 0, 0, 1, 0, 1, 0, 2, 1};
	
	public static void main(String[] args) throws IOException{
		int testCase = Integer.parseInt(br.readLine());
		
		for(int t = 1;t <= testCase;t++) {
			int X = Integer.parseInt(br.readLine());
			String result = "";
			
			if(X == 1) {
				sb.append(0).append("\n");
				continue;
			}
			else {
				if(X % 2 == 0) for(int i = 0;i < X / 2;i++) result += "8";
				else {
					result += "4";
					for(int i = 0;i < X / 2;i++) result += "8";
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