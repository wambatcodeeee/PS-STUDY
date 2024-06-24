import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static boolean check(String str) {
        int len = str.length();

        for(int i = 0; i < len - 1; i++){
            HashSet<String> set = new HashSet<>();

            for(int n = 0; n + i + 1 < len; n++){
                String couple = String.valueOf(str.charAt(n)) + str.charAt(n + i + 1);
                
                if(set.contains(couple)) return false;
                set.add(couple);
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = br.readLine();
            if(str.equals("*")) break;

            if(check(str)) bw.write(str + " is surprising.\n");
            else bw.write(str + " is NOT surprising.\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
