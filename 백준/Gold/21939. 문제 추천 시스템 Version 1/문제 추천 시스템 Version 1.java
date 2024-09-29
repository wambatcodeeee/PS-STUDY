import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        TreeMap<Integer, TreeSet<Integer>> treeMap = new TreeMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int problem = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            treeMap.putIfAbsent(difficulty, new TreeSet<>());
            treeMap.get(difficulty).add(problem);
        }

        int commandNum = Integer.parseInt(br.readLine());

        for(int i = 0; i < commandNum; i++){
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch(command){
                case "recommend":
                    int x = Integer.parseInt(st.nextToken());
                    
                    if(x == 1){
                        int maxDifficulty = treeMap.lastKey();
                        sb.append(treeMap.get(maxDifficulty).last()).append("\n");
                    }else if (x == -1){
                        int minDifficulty = treeMap.firstKey();
                        sb.append(treeMap.get(minDifficulty).first()).append("\n");
                    }
                    break;

                case "add":
                    int problem = Integer.parseInt(st.nextToken());
                    int difficulty = Integer.parseInt(st.nextToken());
                    treeMap.putIfAbsent(difficulty, new TreeSet<>());
                    treeMap.get(difficulty).add(problem);
                    break;

                case "solved":
                    problem = Integer.parseInt(st.nextToken());

                    for(TreeSet<Integer> t : treeMap.values()){
                        if(t.remove(problem)){
                            if(t.isEmpty()) treeMap.values().remove(t);
                            break;
                        }
                    }
                    break;
            }
        }

        System.out.println(sb);
    }
}
