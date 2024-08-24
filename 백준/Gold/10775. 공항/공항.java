import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] parent;

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY) parent[rootX] = rootY;
    }

    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int gate = Integer.parseInt(br.readLine());
        int plane = Integer.parseInt(br.readLine());
        parent = new int[gate + 1];

        for(int i = 0; i < gate; i++){
            parent[i + 1] = i + 1;
        }

        int result = 0;
        boolean flag = false;

        for(int i = 0; i < plane; i++){
            int docking = Integer.parseInt(br.readLine());
            int available = find(docking);
            
            if(flag) continue;
            if(available == 0) flag = true;
            else{
                union(available, available - 1);
                result++;
            }
        }

        System.out.println(result);
    }
}
