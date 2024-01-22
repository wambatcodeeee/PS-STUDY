import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[10];

        for(int i = 0;i < 10;i++){
            int input = sc.nextInt();
            array[i] = input % 42;
        }

        array = Arrays.stream(array).distinct().toArray();
        System.out.println(array.length);
    }
}