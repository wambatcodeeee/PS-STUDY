import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        HashSet<Character> hashSet = new HashSet<>();
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            String line = br.readLine();
            st = new StringTokenizer(line);
            String[] wordArray = new String[st.countTokens()];
            int index = 0;

            while(st.hasMoreTokens()){
                wordArray[index++] = st.nextToken();
            }

            boolean check = false;

            for(int j = 0; j < wordArray.length; j++){
                char c = Character.toLowerCase(wordArray[j].charAt(0));

                if(!hashSet.contains(c)){
                    hashSet.add(c);
                    sb.append(line, 0, line.indexOf(wordArray[j]))
                            .append("[").append(wordArray[j].charAt(0)).append("]")
                            .append(wordArray[j].substring(1));
                    
                    for(int k = j + 1; k < wordArray.length; k++){
                        sb.append(" ").append(wordArray[k]);
                    }
                    
                    sb.append("\n");
                    check = true;
                    break;
                }
            }

            if(!check){
                for(int j = 0; j < line.length(); j++){
                    char c = Character.toLowerCase(line.charAt(j));
                    if(line.charAt(j) != ' ' && !hashSet.contains(c)){
                        hashSet.add(c);
                        sb.append(line, 0, j)
                                .append("[").append(line.charAt(j)).append("]")
                                .append(line.substring(j + 1))
                                .append("\n");
                        check = true;
                        break;
                    }
                }
            }

            if(!check) sb.append(line).append("\n");
        }
        
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
        br.close();
    }
}
