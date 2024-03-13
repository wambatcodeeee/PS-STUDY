import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;

                case "pop_front":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.removeFirst()).append("\n");
                    break;

                case "pop_back":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.removeLast()).append("\n");
                    break;

                case "size":
                    sb.append(deque.size()).append("\n");
                    break;

                case "empty":
                    if(deque.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;

                case "front":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.peek()).append("\n");
                    break;

                case "back":
                    if(deque.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(deque.getLast()).append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}