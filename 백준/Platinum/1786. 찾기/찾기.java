import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static int[] lPSArrayFunction(String pattern){
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while(i < m){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    private static List<Integer> kmp(String text, String pattern) {
        List<Integer> count = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int[] lps = lPSArrayFunction(pattern);

        int i = 0;
        int j = 0;

        while(i < n){
            if(pattern.charAt(j) == text.charAt(i)){
                i++;
                j++;
            }
            if(j == m){
                count.add(i - j + 1);
                j = lps[j - 1];
            }else if (i < n && pattern.charAt(j) != text.charAt(i)){
                if(j != 0){
                    j = lps[j - 1];
                }else{
                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String T = br.readLine();
        String P = br.readLine();

        List<Integer> count = kmp(T, P);

        bw.write(count.size() + "\n");

        for(int match : count){
            bw.write(match + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
