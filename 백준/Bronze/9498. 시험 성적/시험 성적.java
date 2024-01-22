import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(a <= 100 && a >= 90 ? "A" : a <= 89 && a >= 80 ? "B" : a <= 79 && a >= 70 ? "C" : a <= 69 && a >= 60 ? "D" : "F");
    }
}