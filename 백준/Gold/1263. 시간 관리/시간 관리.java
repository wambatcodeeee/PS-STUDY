import java.io.*;
import java.util.*;

public class Main {
    public static class Task {
        int time;
        int deadline;

        Task(int time, int deadline) {
            this.time = time;
            this.deadline = deadline;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        Task[] tasks = new Task[num];

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int deadline = Integer.parseInt(st.nextToken());
            tasks[i] = new Task(time, deadline);
        }

        Arrays.sort(tasks, (a, b) -> b.deadline - a.deadline);

        int result = tasks[0].deadline;

        for(Task task : tasks){
            result = Math.min(result, task.deadline);
            result -= task.time;
            
            if(result < 0){
                System.out.println(-1);
                return;
            }
        }

        System.out.println(result);
    }
}
