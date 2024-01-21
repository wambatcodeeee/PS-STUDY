import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] array = new int[9][9];
        int maxNum = 0;
        int x = 1;
        int y = 1;


        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                array[i][j] = sc.nextInt();
            }
        }

        for (int i = 0;i < 9;i++){
            for (int j = 0;j < 9;j++){
                if(array[i][j] > maxNum){
                    maxNum = array[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }

        System.out.println(maxNum);
        System.out.print(x + " " + y);
    }
}
