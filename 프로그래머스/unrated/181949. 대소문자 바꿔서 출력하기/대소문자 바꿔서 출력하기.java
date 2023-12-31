import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] chrArray = a.toCharArray();

        for (int i=0;i < chrArray.length;i++) {
            if (Character.isUpperCase(chrArray[i])) {
                chrArray[i] = Character.toLowerCase(chrArray[i]);
            }else if(Character.isLowerCase(chrArray[i])){
                chrArray[i] = Character.toUpperCase((chrArray[i]));
            }
        }

        for (char c:chrArray){
            System.out.print(c);
        }
        
        sc.close();
    }
}