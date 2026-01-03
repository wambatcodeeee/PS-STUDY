import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] parent;
    static ArrayList<Integer> arrayList = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> arrayList1 = new ArrayList<>();

    public static int find(int v){
        if(v == parent[v]) return v;
        return parent[v] = find(parent[v]);
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) parent[fb] = fa;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        parent = new int[N + 1];
        for(int i = 0;i <= N;i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truths = Integer.parseInt(st.nextToken());
        if(truths == 0) sb.append(M);
        else{
            for(int i = 0;i < truths;i++) arrayList.add(Integer.parseInt(st.nextToken()));
            for(int i = 1;i < truths;i++) union(arrayList.get(0), arrayList.get(i));

            for(int i = 0;i < M;i++){
                st = new StringTokenizer(br.readLine());
                int count = Integer.parseInt(st.nextToken());
                ArrayList<Integer> party = new ArrayList<>();
                for(int j = 0;j < count;j++) party.add(Integer.parseInt(st.nextToken()));
                arrayList1.add(party);
                for(int j = 1;j < count;j++) union(party.get(0), party.get(j));
            }

            for(ArrayList<Integer> a : arrayList1){
                boolean flag = true;
                for(int num : a){
                    if(find(num) == find(arrayList.get(0))){
                        flag = false;
                        break;
                    }
                }
                if(flag) result++;
            }

            sb.append(result);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}