import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());

        LinkedList<Character> list = new LinkedList<>();

        for(int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        
        ListIterator<Character> iterator = list.listIterator();
        while(iterator.hasNext()) {
            iterator.next();
        }

        for(int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);
            switch(c) {
                case 'L':
                    if(iterator.hasPrevious())
                        iterator.previous();

                    break;
                case 'D':
                    if(iterator.hasNext())
                        iterator.next();

                    break;
                case 'B':
                    if(iterator.hasPrevious()) {
                        iterator.previous();
                        iterator.remove();
                    }
                    break;
                case 'P':
                    char t = command.charAt(2);
                    iterator.add(t);

                    break;
                default:
                    break;
            }
        }
        for(Character chr : list) {
            bw.write(chr);
        }

        bw.flush();
        bw.close();
    }
}