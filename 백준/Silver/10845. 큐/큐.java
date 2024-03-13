import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());
        int tail = -1;

        for(int i = 0;i < num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch (st.nextToken()){
                case "push":
                    tail = Integer.parseInt(st.nextToken());
                    queue.add(tail);
                    break;

                case "pop":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(queue.remove()).append("\n");
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if(queue.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;

                case "front":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(queue.peek()).append("\n");
                    break;

                case "back":
                    if(queue.isEmpty()){
                        sb.append("-1").append("\n");
                        break;
                    }
                    sb.append(tail).append("\n");
            }
        }
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
