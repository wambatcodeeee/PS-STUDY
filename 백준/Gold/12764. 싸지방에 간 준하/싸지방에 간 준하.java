import java.io.*;
import java.util.*;

class Person{
    int startTime;
    int endTime;

    public Person(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Computer{
    int endTime;
    int computerId;
    int count;

    public Computer(int endTime, int computerId){
        this.endTime = endTime;
        this.computerId = computerId;
        this.count = 1;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static Person[] array;
    static PriorityQueue<Computer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.endTime));
    static PriorityQueue<Computer> pq1 = new PriorityQueue<>(Comparator.comparingInt(o -> o.computerId));
    static ArrayList<Computer> arrayList = new ArrayList<>();
    static int computerId = 0;

    public static void solution() throws IOException {
        for(Person p : array){
            while(!pq.isEmpty() && pq.peek().endTime <= p.startTime) {
                pq1.add(pq.poll());
            }
            if(!pq1.isEmpty()){
                Computer c = pq1.poll();
                c.endTime = p.endTime;
                c.count++;
                pq.add(c);
            }

            else{
                Computer c = new Computer(p.endTime, ++computerId);
                arrayList.add(c);
                pq.add(c);
            }
        }

        bw.write(String.valueOf(arrayList.size()));
        bw.newLine();

        for(Computer c : arrayList){
            bw.write(c.count + " ");
        }
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());
        array = new Person[num];

        for(int i = 0;i < num;i++){
            st = new StringTokenizer(br.readLine());
            array[i] = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(array, Comparator.comparingInt(o -> o.startTime));
        solution();

        bw.flush();
        bw.close();
        br.close();
    }
}