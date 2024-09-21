import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static class Lecture {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        Lecture[] lectureArray = new Lecture[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            lectureArray[i] = new Lecture(pay, day);
        }

        Arrays.sort(lectureArray, Comparator.comparingInt((Lecture lec) -> lec.day).thenComparingInt((Lecture lec) -> -lec.pay));

        for(Lecture lecture : lectureArray){
            if(queue.size() < lecture.day) queue.offer(lecture.pay);
            else if(!queue.isEmpty() && queue.peek() < lecture.pay){
                queue.poll();
                queue.offer(lecture.pay);
            }
        }

        int result = 0;

        while(!queue.isEmpty()){
            result += queue.poll();
        }

        System.out.println(result);
    }
}