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
			char[] chars = br.readLine().toCharArray();
			long result = 1;
			
			for(int i = 0;i < chars.length;i++) {
				HashSet<Character> hashSet = new HashSet<>();
				if(chars.length == 1) break;
				if(i == 0 && chars.length != 1) {
					hashSet.add(chars[0]);
					hashSet.add(chars[1]);
				}
				else if(i == chars.length - 1) {
					hashSet.add(chars[i - 1]);
					hashSet.add(chars[i]);
				}
				else {
					hashSet.add(chars[i - 1]);
					hashSet.add(chars[i]);
					hashSet.add(chars[i + 1]);
				}
				result = (result * hashSet.size()) % 1000000007;
			}
			
			sb.append(result).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}