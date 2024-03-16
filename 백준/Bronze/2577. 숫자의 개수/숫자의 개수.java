import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num1 = Integer.parseInt(br.readLine()), num2 = Integer.parseInt(br.readLine()), num3 = Integer.parseInt(br.readLine());
        String mul = String.valueOf(num1 * num2 * num3);

        char[] chrArray = mul.toCharArray();

        for(int i = 0;i < 10;i++){
            int count = 0;
            for(char c:chrArray){
                if(i == Character.getNumericValue(c)){
                    count++;
                }
            }
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
