import java.io.*;
import java.util.Scanner;

class MyStack{
    int[] stack;
    int top;
    int size;

    public MyStack(int order){
        stack = new int[order];
        top = -1;
        size = 0;
    }

    public void push(int num){
        stack[++top] = num;
        size++;
    }

    public int pop(){
        if(isEmpty() == 1) return -1;
        size--;
        return stack[top--];
    }

    public int size(){
        return size;
    }

    public int isEmpty(){
        return top == -1 ? 1 : 0;
    }

    public int peak(){
        return isEmpty() == 1 ? -1 : stack[top];
    }
}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int order = Integer.parseInt(br.readLine());
        MyStack ms = new MyStack(order);

        for(int i = 0;i < order;i++){
            String[] str = br.readLine().split(" ");
            if(str[0].equals("1")){
                ms.push(Integer.parseInt(str[1]));
            } else if (str[0].equals("2")) {
                bw.write(ms.pop() + "\n");
            } else if (str[0].equals("3")) {
                bw.write(ms.size() + "\n");
            } else if (str[0].equals("4")) {
                bw.write(ms.isEmpty() + "\n");
            } else if (str[0].equals("5")) {
                bw.write(ms.peak() + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
