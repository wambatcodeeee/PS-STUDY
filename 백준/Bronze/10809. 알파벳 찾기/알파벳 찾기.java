    import java.util.Scanner;
    import java.util.Arrays;
    
    public class Main {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int[] num = new int[26];
            Arrays.fill(num, -1);
            char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
            'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    
            char[] chrArray = (sc.next()).toCharArray();
    
            for(int i = 0;i < alphabet.length;i++){
                for(int j = 0;j < chrArray.length;j++){
                    if(alphabet[i] == chrArray[j]){
                        if(num[i] == -1){
                            num[i] = j;
                        }
                    }
                }
            }
    
            for (int i = 0; i < num.length; i++) {
                System.out.print(num[i]);
                if (i == (num.length - 1)) {
                    System.out.print("\n");
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
