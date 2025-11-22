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
			String str = br.readLine();
			int first = Integer.parseInt(str.substring(0, 2));
			int second = Integer.parseInt(str.substring(2));
			
			if((first <= 12 && first != 0) && (second > 12 || second == 0)) sb.append("MMYY").append("\n");
			else if((first > 12 || first == 0) && (second <= 12 && second != 0)) sb.append("YYMM").append("\n");
			else if((first <= 12 && first > 0) && (second <= 12) && second > 0) sb.append("AMBIGUOUS").append("\n");
			else if(first > 12 && second > 12) sb.append("NA").append("\n");
			else if((first > 12 && second == 0) || (first == 0 && second > 12)) sb.append("NA").append("\n");
			else sb.append("NA").append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}