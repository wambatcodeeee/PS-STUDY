import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int tab = 0;

        for(int i = 0;i < count;i++){
            tab += sc.nextInt();
        }

        System.out.println(tab - (count - 1));
    }
}
