import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Deque<String> deque = new LinkedList<>();
        LinkedList<Boolean> linkedList = new LinkedList<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0;i < num;i++){
            st = new StringTokenizer(br.readLine());

            switch(st.nextToken()){
                case "1":
                    deque.addLast(st.nextToken());
                    linkedList.add(true);
                    break;

                case "2":
                    deque.addFirst(st.nextToken());
                    linkedList.add(false);
                    break;

                case "3":
                    if(!deque.isEmpty() && !linkedList.isEmpty()){
                        if(linkedList.removeLast()) deque.removeLast();
                        else deque.removeFirst();
                    }
                    break;
            }
        }

        int length = deque.size();

        if(length != 0){
            for(int i = 0;i < length;i++){
                bw.write(deque.removeFirst());
            }
        }else bw.write("0");

        bw.flush();
        bw.close();
        br.close();
    }
}
