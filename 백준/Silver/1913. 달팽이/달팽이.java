import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num_1 = num;
        int input = (int) Math.pow(num, 2);
        int target = sc.nextInt();
        int x = 0;
        int y = 0;
        int[][] numArray = new int[num][num];

        while(input > 0){
            if(num_1 == 1){
                num_1++;
            }
            for(int i = 0;i < num_1 - 1;i++){
                if(input == 0){
                    break;
                }
                numArray[y][x] = input;
                input--;
                y++;
            }

            for(int i = 0;i < num_1 - 1;i++){
                if(input == 0){
                    break;
                }
                numArray[y][x] = input;
                input--;
                x++;
            }

            for(int i = 0;i < num_1 - 1;i++){
                if(input == 0){
                    break;
                }
                numArray[y][x] = input;
                input--;
                y--;
            }


            for(int i = 0;i < num_1 - 1;i++){
                if(input == 0){
                    break;
                }
                numArray[y][x] = input;
                input--;
                x--;
            }

            y++;
            x++;
            if(num_1 == 1){
                break;
            }

            num_1 -= 2;
        }

        StringBuilder sb = new StringBuilder();
        int tx=0, ty=0;
        for(int i=0; i<num; i++) {
            for(int j=0; j<num; j++) {
                if(target==numArray[i][j]) {
                    ty=i+1;
                    tx=j+1;
                }
                sb.append(numArray[i][j] +" ");
            }
            sb.append("\n");
        }
        sb.append(ty+" "+tx);
        System.out.println(sb.toString());
    }
}
