import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M, K;
    static long[] array;
    static long[] segmentTree;

    // node는 트리 노드의 인덱스를 의마
    public static long init(int start, int end, int node){
        if(start == end) return segmentTree[node] = array[start];
        int mid = (start + end) / 2;
        return segmentTree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long query(int start, int end, int node, int left, int right){
        if(start > right || end < left) return 0;
        if(start >= left && end <= right) return segmentTree[node];

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int index, long diff){
        if(start > index || index > end) return;
        segmentTree[node] += diff; // 전체 노드의 누적합 변경ing
        if(start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index, diff);
        update(mid + 1, end, node * 2 + 1, index, diff);
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        array = new long[N];
        segmentTree = new long[N * 4];
        for(int i = 0;i < N;i++) array[i] = Long.parseLong(br.readLine());
        init(0, N - 1, 1);

        while(M + K != 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(a == 1){
                long diff = c - array[b - 1];
                array[b - 1] = c;
                update(0, N - 1, 1, b - 1, diff);
                M--;
            }
            else {
                sb.append(query(0, N - 1, 1, b - 1, (int) c - 1)).append("\n");
                K--;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}