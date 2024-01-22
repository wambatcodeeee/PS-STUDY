import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
        if(a == b && b == c){
            System.out.println(10000 + a * 1000);
        }else if (a != b && b != c && c != a) {
            int max;
            if(a > b){
                max = Math.max(c, a);
            }else{
                max = Math.max(c, b);
            }
            System.out.println(max * 100);
        }else {
            System.out.println(a == b || a == c ? 1000 + a * 100 : 1000 + b * 100);
        }
    }
}