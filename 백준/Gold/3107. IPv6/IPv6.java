import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static String expand(String group) {
        return "0".repeat(Math.max(0, 4 - group.length())) + group;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String[] parts = input.split("::");
        List<String> left = new ArrayList<>(Arrays.asList(parts[0].split(":")));
        List<String> right = new ArrayList<>();

        if (parts.length == 2) {
            right.addAll(Arrays.asList(parts[1].split(":")));
        }

        int zeroGroups = 8 - (left.size() + right.size());
        StringBuilder result = new StringBuilder();

        for (String part : left) {
            result.append(expand(part)).append(":");
        }

        result.append("0000:".repeat(Math.max(0, zeroGroups)));

        for(int i = 0; i < right.size(); i++){
            result.append(expand(right.get(i)));

            if(i < right.size() - 1){
                result.append(":");
            }
        }

        if (result.charAt(result.length() - 1) == ':') {
            result.setLength(result.length() - 1);
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
