import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static boolean[] ch;

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(br.readLine());

        while(num-- > 0){
            HashMap<Character, Integer> hashMap = new HashMap<>();
            String str = br.readLine();
            char[] chars = str.toCharArray();
            ch = new boolean[10];
            boolean flag = true;

            for(char c : chars){
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
                if(hashMap.get(c) > 2){
                    flag = false;
                    break;
                }

                if(!ch[c - '0']){
                    int firstIndex = str.indexOf(c);
                    int secondIndex = str.indexOf(c, firstIndex + 1);

                    if(secondIndex == -1 || secondIndex - firstIndex - 1 != c - '0') {
                        flag = false;
                        break;
                    }

                    ch[c - '0'] = true;
                }
            }

            if(flag) bw.write("yes");
            else bw.write("no");
            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}