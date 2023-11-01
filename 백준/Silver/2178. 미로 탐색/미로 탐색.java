import java.io.*;
import java.util.*;

public class Main {
    
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    private static int n, m;
    private static int[][] maze;
    private static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visited = new boolean[n][m];
        
        input();
        
        System.out.println(bfs());
    }
    
    public static void input() throws IOException {
        
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            
            for (int j=0; j<m; j++) {
                maze[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
    }
    
    public static int bfs() {
        
        Dot start = new Dot(0, 0);
        Queue<Dot> q = new LinkedList<>();
        
        q.add(start);
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            Dot now = q.poll();
            
            int x = now.x;
            int y = now.y;
            
            for (int i=0; i<4; i++) {
                int px = x + dx[i];
                int py = y + dy[i];
                
                if (px < 0 || px >= n || py < 0 || py >=m) {
                    continue;
                }
                
                if (!visited[px][py] && maze[px][py] != 0) {
                    Dot current = new Dot(px, py);
                    visited[px][py] = true;
                    q.add(current);
                    maze[px][py] = maze[x][y] +1;
                }
            }
        }
        
        return maze[n-1][m-1];
    }
}

class Dot {
    
    public int x;
    public int y;
    
    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}