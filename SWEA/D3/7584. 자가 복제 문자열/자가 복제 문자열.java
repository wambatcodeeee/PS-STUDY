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
			long K = Long.parseLong(br.readLine()) - 1;
			
			while(K >= 0) {
				if(K % 2 == 1) K = (K - 1) / 2;
				else if(K % 4 == 0) {
					sb.append("0").append("\n");
					break;
				}
				else if(K % 2 == 0) {
					sb.append("1").append("\n");
					break;
				}
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}