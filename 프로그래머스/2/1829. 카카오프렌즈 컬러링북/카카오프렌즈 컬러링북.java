import java.util.*;

class Node{
    int x;
    int y;
    
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;
    
    static public int BFS(int x, int y, int num){
        Queue<Node> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new Node(x, y));
        int count = 1;
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            for(int i = 0;i < 4;i++){
                int nx = dx[i] + current.x;
                int ny = dy[i] + current.y;
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[ny][nx] == num &&!visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.offer(new Node(nx, ny));
                    count++;
                }
            }
        }
        
        return count;
    }
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        M = m;
        N = n;
        map = picture;
        
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    int area = BFS(j, i, picture[i][j]);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, area);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}