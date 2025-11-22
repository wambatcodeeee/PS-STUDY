import java.util.*;
import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int[] array;
	static int[] bt;
	static int k;
	
	public static void DFS(int L, int start) {
		if(L == bt.length) {
			for(int i : bt) sb.append(i).append(" ");
			sb.append("\n");
		}
		else {
			for(int i = start;i < k;i++) {
				bt[L] = array[i];
				DFS(L + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		while(true) {
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());
			if(k == 0) break;
			array = new int[k];
			bt = new int[6];
			for(int i = 0;i < k;i++) array[i] = Integer.parseInt(st.nextToken());
			DFS(0, 0);
			sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
