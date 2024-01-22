import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        if(b - 45 < 0){
            b += 15;
            a--;
            if(a < 0){
                a += 24;
            }
        }else{
            b -= 45;
        }
        System.out.println(a + " " + b);
    }
}