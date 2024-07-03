import java.io.*;
import java.util.HashMap;

public class Main {
    public static final HashMap<Character, Integer> romanToInt = new HashMap<>();
    public static final StringBuilder sb = new StringBuilder();
    public static final String[] romanArray = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] arabicArray = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public static int romanCharToArabicNum(String romanChar) {
        int result = 0;
        int previous = 0;

        for(int i = romanChar.length() - 1; i >= 0; i--){
            int current = romanToInt.get(romanChar.charAt(i));
            if(current < previous) result -= current;
            else result += current;
            previous = current;
        }
        return result;
    }

    public static String arabicNumToRomanChar(int arabicNum) {
        for(int i = 0; i < arabicArray.length; i++){
            while(arabicNum >= arabicArray[i]) {
                sb.append(romanArray[i]);
                arabicNum -= arabicArray[i];
            }
        }
        return String.valueOf(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        romanToInt.put('I', 1);
        romanToInt.put('V', 5);
        romanToInt.put('X', 10);
        romanToInt.put('L', 50);
        romanToInt.put('C', 100);
        romanToInt.put('D', 500);
        romanToInt.put('M', 1000);

        String romanChar1 = br.readLine();
        String romanChar2 = br.readLine();

        int arabicNum1 = romanCharToArabicNum(romanChar1);
        int arabicNum2 = romanCharToArabicNum(romanChar2);
        int sum = arabicNum1 + arabicNum2;

        String romanSum = arabicNumToRomanChar(sum);

        bw.write(sum + "\n");
        bw.write(romanSum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
