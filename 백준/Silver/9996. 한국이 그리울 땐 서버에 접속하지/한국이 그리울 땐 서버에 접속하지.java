import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] splitPattern = pattern.split("\\*");

        for(int i = 0;i < count;i++){
            String str = br.readLine();

            if(str.length() < splitPattern[0].length() + splitPattern[1].length()){
                System.out.println("NE");
                continue;
            }

            if(str.startsWith(splitPattern[0]) && str.endsWith(splitPattern[1])) System.out.println("DA");
            else System.out.println("NE");
        }
        br.close();
    }
}
