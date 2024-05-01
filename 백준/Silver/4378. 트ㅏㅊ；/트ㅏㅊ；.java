import java.io.*;

public class Main {
    static String[] line = {"`1234567890-=", "QWERTYUIOP[]\\", "ASDFGHJKL;'", "ZXCVBNM,./"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while((input = br.readLine()) != null) {
            char[] chars = input.toCharArray();

            for(char c : chars) {
                if (c == ' ') {
                    sb.append(" ");
                    continue;
                }

                boolean found = false;
                for(String s : line) {
                    if(s.contains(String.valueOf(c))) {
                        sb.append(s.charAt(s.indexOf(String.valueOf(c)) - 1));
                        found = true;
                        break;
                    }
                }

                if(!found) {
                    sb.append(c);
                }
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
