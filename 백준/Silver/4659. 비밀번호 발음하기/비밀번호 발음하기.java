import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static String evaluatePassword(String password) {
        String moum = "aeiou";
        boolean hasVowel = false;
        for (char ch : password.toCharArray()) {
            if (moum.indexOf(ch) != -1) {
                hasVowel = true;
                break;
            }
        }
        if (!hasVowel) {
            return "is not acceptable.";
        }

        for (int i = 0; i < password.length() - 2; i++) {
            if (moum.indexOf(password.charAt(i)) != -1 && moum.indexOf(password.charAt(i + 1)) != -1 &&
                    moum.indexOf(password.charAt(i + 2)) != -1) {
                return "is not acceptable.";
            }
            if (moum.indexOf(password.charAt(i)) == -1 && moum.indexOf(password.charAt(i + 1)) == -1 &&
                    moum.indexOf(password.charAt(i + 2)) == -1) {
                return "is not acceptable.";
            }
        }

        for (int i = 0; i < password.length() - 1; i++) {
            if (password.charAt(i) == password.charAt(i + 1) && password.charAt(i) != 'e' && password.charAt(i) != 'o') {
                return "is not acceptable.";
            }
        }

        return "is acceptable.";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String password = br.readLine();
            if (password.equals("end")) {
                break;
            }
            bw.write("<" + password + "> " + evaluatePassword(password) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

