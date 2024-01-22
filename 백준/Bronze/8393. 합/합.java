import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        int result = 0;
        for(int i = a;i > 0;i--){
            result += i;
        }
        System.out.println(result);
    }
}