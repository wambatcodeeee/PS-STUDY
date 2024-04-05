import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static String function1(String word) {
        String key = word;
        if (word.length() > 2) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray, 1, charArray.length - 1);
            key = charArray[0] + "-" + charArray[charArray.length - 1] + "-" + new String(charArray, 1, charArray.length - 2);
        } else if (word.length() == 2) {
            key = word.charAt(0) + "-" + word.charAt(1);
        }
        return key;
    }

    private static Map<String, String> function2(String[] wordList) {
        Map<String, String> matchingDict = new HashMap<>();
        for (String word : wordList) {
            String key = function1(word);
            matchingDict.put(key, word);
        }
        return matchingDict;
    }

    private static String function3(String[] wordList, String S) {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(S);
        Map<String, String> matchingDict = function2(wordList);
        while (st.hasMoreTokens()) {
            String word = st.nextToken();
            String key = function1(word);
            sb.append(matchingDict.getOrDefault(key, word)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] wordList = new String[N];
        for (int i = 0; i < N; i++) {
            wordList[i] = br.readLine().trim();
        }

        int M = Integer.parseInt(br.readLine());
        String S = br.readLine().trim();

        bw.write(function3(wordList, S));
        bw.flush();
        bw.close();
        br.close();
    }
}
