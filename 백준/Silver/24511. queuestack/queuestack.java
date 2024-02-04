import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] boolArr = new boolean[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < N;i++){
            if(Integer.parseInt(st.nextToken()) == 0) boolArr[i] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < N;i++){
            int N1 = Integer.parseInt(st.nextToken());
            if(boolArr[i]) stack.add(N1);
        }

        while(!stack.isEmpty()){
            queue.add(stack.pop());
        }

        int N2 = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0;i < N2;i++){
            int N3 = Integer.parseInt(st.nextToken());
            queue.add(N3);
            bw.write(queue.remove() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
