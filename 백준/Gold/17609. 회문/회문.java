import java.io.*;

public class Main {
    public static boolean checkPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static boolean checkPseudoPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return checkPalindrome(s.substring(left, right)) || checkPalindrome(s.substring(left + 1, right + 1));
            left++;
            right--;
        }
        return true;
    }

    public static int checkType(String s) {
        if(checkPalindrome(s)) return 0;
        else if(checkPseudoPalindrome(s)) return 1;
        else return 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine().trim());
        String[] strings = new String[T];

        for (int i = 0; i < T; i++) {
            strings[i] = br.readLine().trim();
        }

        for (String s : strings) {
            bw.write(checkType(s) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
