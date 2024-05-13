import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++) {
            StringBuilder result = new StringBuilder();
            LinkedList<Character> linkedList = new LinkedList<>();
            String input = br.readLine();
            char[] chars = input.toCharArray();
            int pointer = 0;

            for(char c : chars){
                switch(c){
                    case '<':
                        if(pointer > 0) pointer--;
                        break;

                    case '>':
                        if(pointer < linkedList.size()) pointer++;
                        break;

                    case '-':
                        if(pointer > 0) {
                            linkedList.remove(pointer - 1);
                            pointer--;
                        }
                        break;

                    default:
                        linkedList.add(pointer, c);
                        pointer++;
                        break;
                }
            }

            for(char c : linkedList){
                result.append(c);
            }

            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
