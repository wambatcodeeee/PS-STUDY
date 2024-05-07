import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int groups = Integer.parseInt(st.nextToken());
        int questions = Integer.parseInt(st.nextToken());

        for(int i = 0; i < groups; i++){
            String groupName = br.readLine();
            int members = Integer.parseInt(br.readLine());

            hashMap.put(groupName, new ArrayList<>());

            for(int j = 0; j < members; j++){
                String memberName = br.readLine();
                hashMap.get(groupName).add(memberName);
                Collections.sort(hashMap.get(groupName));
            }
        }

        for(int i = 0; i < questions; i++){
            String questionName = br.readLine();
            int questionNum = Integer.parseInt(br.readLine());

            switch(questionNum){
                case 0:
                    for(int j = 0;j < hashMap.get(questionName).size();j++){
                        bw.write(hashMap.get(questionName).get(j) + "\n");
                    }
                    break;

                case 1:
                    for(String key : hashMap.keySet()){
                        if(hashMap.get(key).contains(questionName)){
                            bw.write(key + "\n");
                        }
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}