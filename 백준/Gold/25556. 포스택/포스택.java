import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken());
        int[] array = new int[length];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer>[] deque = new ArrayDeque[4];
        for(int i = 0; i < 4; i++){
            deque[i] = new ArrayDeque<>();
        }

        int outNum = length;

        for(int i = length - 1; i >= 0; i--){
            boolean check = false;
            for(int j = 0; j < 4; j++){
                if(deque[j].isEmpty() || deque[j].peek() > array[i]){
                    deque[j].push(array[i]);
                    check = true;
                    break;
                }
            }

            if(!check){
                System.out.println("NO");
                return;
            }

            while(true){
                boolean flag = false;
                for(int j = 0; j < 4; j++){
                    if(!deque[j].isEmpty() && deque[j].peek() == outNum){
                        deque[j].pop();
                        outNum--;
                        flag = true;
                        break;
                    }
                }

                if(!flag) break;
            }
        }

        System.out.println("YES");
    }
}
