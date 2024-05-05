import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String startStr = st.nextToken();
        String endStr = st.nextToken();
        String streamEndStr = st.nextToken();
        int ans = 0;

        HashSet<String> startSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        String input;

        while((input = br.readLine()) != null){
            String[] splitInput = input.split(" ");
            String time = splitInput[0];
            String nickname = splitInput[1];

            if(time.compareTo(startStr) <= 0){
                startSet.add(nickname);
            }else if (time.compareTo(endStr) >= 0 && time.compareTo(streamEndStr) <= 0){
                endSet.add(nickname);
            }
        }

        for(String attendee : endSet){
            if(startSet.contains(attendee)){
                ans++;
            }
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
        br.close();
    }
}
