import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maxNum = 0;
        int cnt = 0;

        for(int i = 0;i < 9;i++){
            int num = sc.nextInt();
            if(num > maxNum){
                maxNum = num;
                cnt = i + 1;
            }
        }
        System.out.println(maxNum);
        System.out.println(cnt);
    }
}
