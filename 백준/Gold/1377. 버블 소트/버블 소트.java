import java.io.*;
import java.util.*;
import java.util.Queue;

class Node {
    int value;
    int index;

    public Node(int value, int index){
        this.value = value;
        this.index = index;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(Node[] nodes1, Node[] nodes2) throws IOException {
        int result = 0;
        HashMap<Integer, Queue<Integer>> hashMap = new HashMap<>();

        for(Node node : nodes1){
            hashMap.computeIfAbsent(node.value, k -> new LinkedList<>()).add(node.index);
        }

        for(Node node : nodes2){
            int index = hashMap.get(node.value).poll();
            int diff = index - node.index;
            if(diff > result) result = diff;
        }

        bw.write(String.valueOf(result + 1));
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        int[] array = new int[num];
        Node[] nodes1 = new Node[num];
        Node[] nodes2 = new Node[num];

        for(int i = 0;i < num;i++){
            array[i] = Integer.parseInt(br.readLine());
            nodes1[i] = new Node(array[i], i);
        }

        Arrays.sort(array);

        for(int i = 0;i < num;i++){
            nodes2[i] = new Node(array[i], i);
        }

        solution(nodes1, nodes2);

        bw.close();
        br.close();
    }
}