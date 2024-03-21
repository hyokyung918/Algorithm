import java.io.*;
import java.util.*;

class Main {
    
    private static int m, n;
    private static int[][] map;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visit = new boolean[m][n];
        
        for (int i=0; i<m; i++) {
            String s = br.readLine();
            for (int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        
        for (int i=0; i<n; i++) {
            if (map[0][i]==0 && !visit[0][i]) {
                bfs(i);
            }
        }
        
        for (int i=0; i<n; i++) {
            if (visit[m-1][i]) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    
    private static void bfs(int x) {
        
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(x, 0));
        visit[0][x] = true;
        
        while (!q.isEmpty()) {
            Dot now = q.poll();
            
            for (int i=0; i<4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];
                
                if (mx<0 || my<0 || mx>=n || my>=m) continue;
                if (map[my][mx] == 0 && !visit[my][mx]) {
                    q.add(new Dot(mx, my));
                    visit[my][mx] = true;
                }
            }
        }
    }
    
    private static class Dot {
        
        int x, y;
        
        Dot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}