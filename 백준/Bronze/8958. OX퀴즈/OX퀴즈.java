import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String [] strArray = new String[sc.nextInt()];
        int count = 0;

        for(int i = 0;i < strArray.length;i++){
            strArray[i] = sc.next();
        }

        while(count < strArray.length){
            int score = 0;
            int stack = 0;
            char[] chrArray = strArray[count].toCharArray();

            for(char c:chrArray){
                if(c == 'O'){
                    score += 1 + stack;
                    stack++;
                }else if (c == 'X') {
                    stack = 0;
                }
            }
            System.out.println(score);
            count++;
        }
    }
}
