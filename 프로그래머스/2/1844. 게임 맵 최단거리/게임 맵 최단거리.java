import java.util.*;

class Node{
    int x;
    int y;
    int count;
    
    public Node(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, answer;
    
    static int BFS(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0, 1));
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(current.x == M - 1 && current.y == N - 1) return current.count;
            
            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[ny][nx] && map[ny][nx] == 1){
                    visited[ny][nx] = true;
                    queue.add(new Node(nx, ny, current.count + 1));
                }
            }
        }
        return -1;
    }
    
    public int solution(int[][] maps) {
        map = maps;
        N = maps.length;
        M = maps[0].length;
        visited = new boolean[N][M];
        visited[0][0] = true;
        
        return BFS();
    }
}