import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static StringBuilder Machine(Deque<Integer> deque, String order){
        StringBuilder sb = new StringBuilder("[");
        boolean flag = false;
        char[] chrArray = order.toCharArray();

        for(char c:chrArray){
            if(c == 'R'){
                flag = !flag;
            }else{
                if(deque.isEmpty()){
                    return new StringBuilder("error");
                }
                if(flag){
                    deque.pollLast();
                }else{
                    deque.pollFirst();
                }
            }
        }

        while(!deque.isEmpty()){
            sb.append(flag ? deque.pollLast() : deque.pollFirst());
            if(!deque.isEmpty()){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0;i < T;i++){
            Deque<Integer> deque = new LinkedList<>();
            String order = br.readLine();
            int num = Integer.parseInt(br.readLine());
            String array = br.readLine();
            for(String s:array.substring(1, array.length() - 1).split(",")){
                if(!s.isEmpty()) deque.add(Integer.valueOf(s));
            }
            System.out.println(Machine(deque, order));
        }
    }
}