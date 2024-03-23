import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double result = 0;
        double result1 = 0;

        for(int i = 0;i < 20;i++){
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String score = st.nextToken();

            switch(score){
                case "A+":
                    result += point * 4.5;
                    result1 += point;
                    break;
                case "A0":
                    result += point * 4.0;
                    result1 += point;
                    break;
                case "B+":
                    result += point * 3.5;
                    result1 += point;
                    break;
                case "B0":
                    result += point * 3.0;
                    result1 += point;
                    break;
                case "C+":
                    result += point * 2.5;
                    result1 += point;
                    break;
                case "C0":
                    result += point * 2.0;
                    result1 += point;
                    break;
                case "D+":
                    result += point * 1.5;
                    result1 += point;
                    break;
                case "D0":
                    result += point;
                    result1 += point;
                    break;
                case "F":
                    result += point * 0;
                    result1 += point;
            }
        }

        System.out.print(Math.round((result / result1) * 1e6) / 1e6);
    }
}
