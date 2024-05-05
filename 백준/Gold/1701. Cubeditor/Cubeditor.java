import java.io.*;

public class Main {
    private static int findMax(String s) {
        int n = s.length();
        int max = 0;

        for(int i = 0; i < n; i++){
            String substring = s.substring(i, n);
            int len = getPi(substring);
            max = Math.max(max, len);
        }

        return max;
    }

    private static int getPi(String s) {
        int[] pi = new int[s.length()];
        int j = 0, max = 0;

        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = pi[j - 1];
            }

            if(s.charAt(i) == s.charAt(j)){
                max = Math.max(max, pi[i] = j += 1);
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int max = findMax(s);

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}
