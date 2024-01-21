import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double num = sc.nextDouble();
        double max = 0;
        double result = 0;

        double[] intArray = new double[(int) num];
        for(int i = 0;i < num;i++){
            intArray[i] = sc.nextInt();
        }

        for(double i:intArray){
            max = Math.max(i, max);
        }

        for(int i = 0;i < intArray.length;i++){
            intArray[i] = (intArray[i] / max) * 100;
        }

        for (double i : intArray) {
            result += i;
        }

        System.out.println(result / intArray.length);
    }
}
