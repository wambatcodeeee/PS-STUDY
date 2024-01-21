import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        String result = "";

        for(int i = 0;i < rows;i++){
            for(int j = 1;j < rows - i;j++){
                result += " ";
            }

            for(int k = 0;k < 2*i+1;k++){
                result += "*";
            }
            result += "\n";
        }
        System.out.println(result);
    }
}
