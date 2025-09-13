import java.io.*;
import java.util.*;

class Node{
    char data;
    Node lt, rt;
    public Node(char val){
        data = val;
        lt=rt=null;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Node[] tree;

    public static void preOrder(Node root) throws IOException{
        if(root == null) return;
        else {
            bw.write(String.valueOf(root.data));
            bw.flush();
            preOrder(root.lt);
            preOrder(root.rt);
        }
    }

    public static void inOrder(Node root) throws IOException{
        if(root == null) return;
        else {
            inOrder(root.lt);
            bw.write(String.valueOf(root.data));
            bw.flush();
            inOrder(root.rt);
        }
    }

    public static void postOrder(Node root) throws IOException{
        if(root == null) return;
        else {
            postOrder(root.lt);
            postOrder(root.rt);
            bw.write(String.valueOf(root.data));
            bw.flush();
        }
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        tree = new Node[num];

        for(int i = 0;i < num;i++){
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);

            if(tree[root - 'A'] == null) tree[root - 'A'] = new Node(root);
            if(lt != '.') {
                tree[lt - 'A'] = new Node(lt);
                tree[root - 'A'].lt = tree[lt - 'A'];
            }
            if(rt != '.') {
                tree[rt - 'A'] = new Node(rt);
                tree[root - 'A'].rt = tree[rt - 'A'];
            }
        }

        preOrder(tree[0]);
        bw.newLine();
        inOrder(tree[0]);
        bw.newLine();
        postOrder(tree[0]);
        bw.newLine();
        
        bw.close();
        br.close();
    }
}