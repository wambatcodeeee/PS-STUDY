import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Document{
        int index;
        int priority;

        public Document(int index, int priority){
            this.index = index;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        while(num--> 0){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<Document> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                queue.add(new Document(i, Integer.parseInt(st.nextToken())));
            }

            int order = 1;

            while(!queue.isEmpty()){
                Document document = queue.poll();
                boolean flag = true;

                for(Document d : queue){
                    if(d.priority > document.priority){
                        flag = false;
                        break;
                    }
                }

                if(flag){
                    if(document.index == M){
                        bw.write(order + "\n");
                        break;
                    }else{
                        order++;
                    }
                }else{
                    queue.add(document);
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
