import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        Deque<String>[] deque = new ArrayDeque[num];

        for(int i = 0; i < num; i++){
            deque[i] = new ArrayDeque<>();
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                deque[i].offer(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        boolean check = true;

        while(st.hasMoreTokens() && check){
            String word = st.nextToken();
            boolean found = false;
            for(int i = 0; i < num; i++){
                if(!deque[i].isEmpty() && deque[i].peek().equals(word)){
                    deque[i].poll();
                    found = true;
                    break;
                }
            }
            if(!found) check = false;
        }
        
        for(int i = 0; i < num; i++){
            if(!deque[i].isEmpty()){
                check = false;
                break;
            }
        }

        if(check) System.out.println("Possible");
        else System.out.println("Impossible");
    }
}
