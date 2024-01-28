import java.io.*;
import java.util.LinkedList;

class Queue{
    LinkedList<Integer> queue;

    public Queue(){
        this.queue = new LinkedList<>();
    }

    public void push(int num){
        queue.addFirst(num);
    }

    public int pop(){
        return queue.isEmpty() ? -1 : queue.removeLast();
    }

    public int size(){
        return queue.size();
    }

    public int isEmpty(){
        return queue.isEmpty() ? 1 : 0;
    }

    public int front(){
        return queue.isEmpty() ? -1 : queue.getLast();
    }

    public int back(){
        return queue.isEmpty() ? -1 : queue.getFirst();
    }
}

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = Integer.parseInt(br.readLine());
        Queue queue = new Queue();

        for(int i = 0;i < order;i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("push")){
                queue.push(Integer.parseInt(str[1]));
            } else if (str[0].equals("pop")) {
                bw.write(queue.pop() + "\n");
            } else if (str[0].equals("size")) {
                bw.write(queue.size() + "\n");
            } else if (str[0].equals("empty")) {
                bw.write(queue.isEmpty() + "\n");
            } else if (str[0].equals("front")) {
                bw.write(queue.front() + "\n");
            } else if (str[0].equals("back")) {
                bw.write(queue.back() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
