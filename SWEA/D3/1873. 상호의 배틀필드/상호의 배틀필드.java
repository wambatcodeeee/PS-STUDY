import java.io.*;
import java.util.*;

public class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int H, W, N;
    static char[][] map;
    static char[] command;
    static int playerH, playerW, view;

    public static void shoot(){
        if(view == 2) {
            for(int i = playerH;i < H;i++) {
                if(map[i][playerW] == '*') {
                    map[i][playerW] = '.';
                    break;
                }
                else if(map[i][playerW] == '#') break;
            }
        }
        else if(view == 4) {
            for(int i = playerW;i >= 0;i--) {
                if(map[playerH][i] == '*') {
                    map[playerH][i] = '.';
                    break;
                }
                else if(map[playerH][i] == '#') break;
            }
        }
        else if(view == 6) {
            for(int i = playerW;i < W;i++) {
                if(map[playerH][i] == '*') {
                    map[playerH][i] = '.';
                    break;
                }
                else if(map[playerH][i] == '#') break;
            }
        }
        if(view == 8) {
            for(int i = playerH;i >= 0;i--) {
                if(map[i][playerW] == '*') {
                    map[i][playerW] = '.';
                    break;
                }
                else if(map[i][playerW] == '#') break;
            }
        }
    }

    public static void move(char direction){
        if(direction == 'U'){
            if(playerH > 0 && map[playerH - 1][playerW] == '.') {
                map[playerH - 1][playerW] = '^';
                map[playerH][playerW] = '.';
                playerH--;
            }else map[playerH][playerW] = '^';
            view = 8;
        }
        else if(direction == 'D'){
            if(playerH < H - 1 && map[playerH + 1][playerW] == '.') {
                map[playerH + 1][playerW] = 'v';
                map[playerH][playerW] = '.';
                playerH++;
            }else map[playerH][playerW] = 'v';
            view = 2;
        }
        else if(direction == 'L'){
            if(playerW > 0 && map[playerH][playerW - 1] == '.') {
                map[playerH][playerW - 1] = '<';
                map[playerH][playerW] = '.';
                playerW--;
            }else map[playerH][playerW] = '<';
            view = 4;
        }
        else if(direction == 'R'){
            if(playerW < W - 1 && map[playerH][playerW + 1] == '.') {
                map[playerH][playerW + 1] = '>';
                map[playerH][playerW] = '.';
                playerW++;
            }else map[playerH][playerW] = '>';
            view = 6;
        }
    }

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());
        int level = 1;

        while(testCase-- > 0){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            map = new char[H][W];
            playerH = 0;
            playerW = 0;
            view = 0;

            for(int i = 0;i < H;i++){
                String str = br.readLine();
                for(int j = 0;j < W;j++) {
                    map[i][j] = str.charAt(j);
                    switch(str.charAt(j)){
                        case '^':
                            view = 8;
                            playerH = i;
                            playerW = j;
                            break;
                        case '>':
                            view = 6;
                            playerH = i;
                            playerW = j;
                            break;
                        case '<':
                            view = 4;
                            playerH = i;
                            playerW = j;
                            break;
                        case 'v':
                            view = 2;
                            playerH = i;
                            playerW = j;
                            break;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            command = br.readLine().toCharArray();

            for(int i = 0;i < N;i++){
                char current = command[i];
                if(current == 'S') shoot();
                else move(current);
            }

            sb.append("#").append(level).append(" ");
            for(int i = 0;i < W;i++) sb.append(map[0][i]);
            sb.append("\n");
            for(int i = 1;i < H;i++){
                for(int j = 0;j < W;j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            level++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}