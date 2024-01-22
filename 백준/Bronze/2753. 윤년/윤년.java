import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a = new Scanner(System.in).nextInt();
        System.out.println(a % 400 == 0 || (a % 100 != 0 && a % 4 == 0)? 1 : 0);
    }
}