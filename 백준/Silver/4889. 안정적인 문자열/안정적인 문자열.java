import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = 1;

        while(true){
            String temp = br.readLine();
            if(temp.charAt(0)=='-') break;

            int count = 0;
            int open = 0;

            for(int i = 0; i < temp.length(); i++){
                char c = temp.charAt(i);
                if(c == '{'){
                    open++;
                }else{
                    if(open == 0){
                        count++;
                        open++;
                    }else{
                        open--;
                    }
                }
            }
            sb.append((n++)).append(". ").append(count + open / 2).append("\n");
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
