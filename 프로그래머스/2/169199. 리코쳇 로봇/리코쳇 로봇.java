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
    static int N, M;
    static String[] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    static int BFS(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y, 0));
        visited = new boolean[N][M];
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if(map[current.x].charAt(current.y) == 'G') return current.count;
            
            for(int i = 0;i < 4;i++){
                int nx = current.x;
                int ny = current.y;
            
                while(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx].charAt(ny) != 'D'){
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];
                
                if(!visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, current.count + 1));
                }
            }
        }
        
        return -1;
    }
    public int solution(String[] board) {
        int answer = 0;
        map = board;
        N = board.length;
        M = board[0].length();
        for(int i = 0;i < N;i++){
            for(int j = 0;j < M;j++){
                if(board[i].charAt(j) == 'R') answer = BFS(i, j);
            }
        }
        return answer;
    }
}