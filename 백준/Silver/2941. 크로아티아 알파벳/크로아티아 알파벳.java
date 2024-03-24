import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] strArr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(String s:strArr){
            if(str.contains(s)){
                str = str.replace(s, " ");
            }
        }

        System.out.print(str.length());
    }
}
