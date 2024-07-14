import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String quack = br.readLine();
        int[] state = new int[5];
        int ducks = 0;
        int max = 0;

        for(char c : quack.toCharArray()){
            switch (c){
                case 'q':
                    if (state[4] > 0) state[4]--;
                    state[0]++;
                    ducks++;
                    max = Math.max(max, ducks);
                    break;
                case 'u':
                    if(state[0] > 0){
                        state[0]--;
                        state[1]++;
                    } else{
                        System.out.println("-1");
                        return;
                    }
                    break;
                case 'a':
                    if(state[1] > 0){
                        state[1]--;
                        state[2]++;
                    } else{
                        System.out.println("-1");
                        return;
                    }
                    break;
                case 'c':
                    if(state[2] > 0){
                        state[2]--;
                        state[3]++;
                    } else{
                        System.out.println("-1");
                        return;
                    }
                    break;
                case 'k':
                    if(state[3] > 0){
                        state[3]--;
                        state[4]++;
                        ducks--;
                    } else{
                        System.out.println("-1");
                        return;
                    }
                    break;
                default:
                    System.out.println("-1");
                    return;
            }
        }

        for(int i = 0; i < 4; i++){
            if(state[i] != 0){
                System.out.println("-1");
                return;
            }
        }
        System.out.println(max);
    }
}
