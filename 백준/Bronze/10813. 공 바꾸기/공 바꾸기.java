import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int basket = sc.nextInt();
        int count = sc.nextInt();
        int[] ball = new int[basket];

        for(int i = 0;i < basket;i++){
            ball[i] = i + 1;
        }

        for(int i = 0;i < count;i++){
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int temp;

            temp = ball[a];
            ball[a] = ball[b];
            ball[b] = temp;
        }

        for(int i:ball){
            System.out.print(i + " ");
        }
    }
}