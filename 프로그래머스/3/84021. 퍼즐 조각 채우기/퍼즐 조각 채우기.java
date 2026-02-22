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
    static int N, answer;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1 ,1};
    
    static ArrayList<Node> BFS(int x, int y, int num, int[][] board){
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Node> shape = new ArrayList<>();
        
        queue.offer(new Node(x, y));
        shape.add(new Node(0, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            for(int i = 0;i < 4;i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && board[nx][ny] == num){
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    shape.add(new Node(nx - x, ny - y));
                }
            }
        }
        
        normalize(shape);
        return shape;
    }
    
    static void normalize(ArrayList<Node> shape){
        Collections.sort(shape, (a, b) -> {
            if(a.x == b.x) return a.y - b.y;
            return a.x - b.x;
        });
        
        int minX = shape.get(0).x;
        int minY = shape.get(0).y;
        
        for(Node n : shape){
            n.x -= minX;
            n.y -= minY;
        }
    }
    
    static boolean match(ArrayList<Node> blank, ArrayList<Node> piece){
        if(blank.size() != piece.size()) return false;
        for(int i = 0;i < 4;i++){
            if(equal(blank, piece)) return true;
            rotate(piece);
        }
        return false;
    }
    
    static boolean equal(ArrayList<Node> blank, ArrayList<Node> piece){
        for(int i = 0;i < blank.size();i++){
            if(blank.get(i).x != piece.get(i).x || blank.get(i).y != piece.get(i).y) return false;
        }
        return true;
    }
    
    static void rotate(ArrayList<Node> piece){
        for(Node n : piece){
            int x = n.x;
            int y = n.y;
            
            n.x = y;
            n.y = -x;
        }
        
        normalize(piece);
    }
    
    public int solution(int[][] game_board, int[][] table) {
        answer = 0;
        N = game_board.length;
        ArrayList<ArrayList<Node>> blank = new ArrayList<>();
        ArrayList<ArrayList<Node>> piece = new ArrayList<>();
        
        visited = new boolean[N][N];
        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                if(game_board[i][j] == 0 && !visited[i][j]) blank.add(BFS(i, j, 0, game_board));
            }
        }
        
        visited = new boolean[N][N];
        for(int i = 0;i < N;i++){
            for(int j = 0;j < N;j++){
                if(table[i][j] == 1 && !visited[i][j]) piece.add(BFS(i, j, 1, table));
            }
        }
        
        boolean[] usedPiece = new boolean[piece.size()];
        for(ArrayList<Node> b : blank){
            for(int i = 0;i < piece.size();i++){
                if(usedPiece[i]) continue;
                ArrayList<Node> p = piece.get(i);
                
                if(match(b, p)){
                    answer += b.size();
                    usedPiece[i] = true;
                    break;    
                }
            }
        }
        
        return answer;
    }
}