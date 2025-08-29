import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void solution(String target, ArrayList<Integer> arrayList) throws IOException {
        int result = Math.abs(Integer.parseInt(target) - 100);

        for(int i = 0;i <= 1000000;i++) {
            boolean flag = true;
            String current = String.valueOf(i);

            for(char c : current.toCharArray()){
                if(!arrayList.contains(Character.getNumericValue(c))){
                    flag = false;
                    break;
                }
            }

            if(flag){
                result = Math.min(result, Math.abs(i - Integer.parseInt(target)) + current.length());
            }
        }
        bw.write(String.valueOf(result));
    }



    public static void main(String[] args) throws IOException {
        String target = br.readLine();
        int bad = Integer.parseInt(br.readLine());
        ArrayList<Integer> badList = new ArrayList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        if(bad != 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0;i < bad;i++){
                badList.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i = 0;i < 10;i++){
            if(!badList.contains(i)) arrayList.add(i);
        }

        solution(target, arrayList);
        bw.close();
        br.close();
    }
}