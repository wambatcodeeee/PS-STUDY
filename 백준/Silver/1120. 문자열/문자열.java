import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str1 = st.nextToken();
        String str2 = st.nextToken();
        String temp = String.valueOf(str1);
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        int count = 0;
        int index = 0;
        int difference = Integer.MAX_VALUE;

        if(chars1.length == chars2.length){
            for(char c:chars1){
                if(c != chars2[index]){
                    count++;
                }
                index++;
            }
            System.out.print(count);
        }else {
            for (int i = 0; i <= str2.length() - str1.length(); i++) {
                count = 0;
                for (int j = 0; j < str1.length(); j++) {
                    if (str1.charAt(j) != str2.charAt(i + j)) {
                        count++;
                    }
                }
                difference = Math.min(difference, count);
            }
            System.out.print(difference);
        }
    }
}
