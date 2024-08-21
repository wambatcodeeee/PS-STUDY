import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arrowArray = new int[1000001];

        int num = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int result = 0;
        
        for(int i = 0; i < num; i++){
            int height = Integer.parseInt(st.nextToken());
            
            if(arrowArray[height] > 0){
                arrowArray[height]--;
                arrowArray[height - 1]++;
            }else{
                result++;
                arrowArray[height - 1]++;
            }
        }

        System.out.println(result);
    }
}
