import java.util.*;

class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int row = storage.length;
        int col = storage[0].length();
        char[][] map = new char[row + 2][col + 2];
        for(int i = 0;i < row + 2;i++){
            Arrays.fill(map[i], '0');
        }
        
        for(int i = 0;i < row;i++){
            for(int j = 0;j < col;j++){
                map[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
        
        for(String s : requests){
            if(s.length() == 1){
                boolean[][] visited = new boolean[row + 2][col + 2];
                Queue<int[]> queue = new LinkedList<>();
                queue.offer(new int[]{0, 0});
                visited[0][0] = true;
                
                while(!queue.isEmpty()){
                    int[] current = queue.poll();
                    
                    for(int i = 0;i < 4;i++){
                        int ny = current[0] + dy[i];
                        int nx = current[1] + dx[i];
                        
                        if(ny >= 0 && ny < row + 2 && nx >= 0 && nx < col + 2){
                            if(!visited[ny][nx]){
                                if(map[ny][nx] == '0'){
                                    visited[ny][nx] = true;
                                    queue.offer(new int[]{ny, nx});
                                }
                                else if(map[ny][nx] == s.charAt(0)){
                                    visited[ny][nx] = true;
                                    map[ny][nx] = '0';
                                }
                            }
                        }
                    }
                }
            }
            
            else{
                for(int i = 1;i <= row;i++){
                    for(int j = 1;j <= col;j++){
                        if(map[i][j] == s.charAt(0)) map[i][j] = '0';
                    }
                }
            }
        }
        
        for(int i = 1;i <= row;i++){
            for(int j = 1;j <= col;j++){
                if(map[i][j] != '0') answer++;
            }
        }
        
        return answer;
    }
}