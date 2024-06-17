import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, Boolean> map = new HashMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String attendance = st.nextToken();

            if(attendance.equals("enter"))  map.put(name, true);
            else if(attendance.equals("leave")) map.put(name, false);
        }

        ArrayList<String> arrayList = new ArrayList<>();
        for(String name : map.keySet()){
            if(map.get(name)){
                arrayList.add(name);
            }
        }

        Collections.sort(arrayList, Collections.reverseOrder());

        for(String name : arrayList){
            bw.write(name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}