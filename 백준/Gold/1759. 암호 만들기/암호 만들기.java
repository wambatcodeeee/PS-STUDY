import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int L, C;
    static char[] words;
    static char[] codes;

    public static void DFS(int x, int v){
        if(v == L){
            int vowel = 0;
            int conso = 0;

            for(char c : codes){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowel++;
                else conso++;
            }

            if(vowel >= 1 && conso >= 2) sb.append(new String(codes)).append("\n");
            return;
        }

        for(int i = x;i < C;i++){
            codes[v] = words[i];
            DFS(i + 1, v + 1);
        }
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        words = new char[C];
        codes = new char[L];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i < C;i++) words[i] = st.nextToken().charAt(0);
        Arrays.sort(words);

        DFS(0, 0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}