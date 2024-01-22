import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        int c = sc.nextInt();

        int m = 60 * a + b;
        m += c;

        int h = (m / 60) % 24;
        int min = m % 60;
        System.out.println(h + " " + min);
    }
}