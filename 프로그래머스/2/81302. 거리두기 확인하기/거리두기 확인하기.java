import java.util.*;

class Solution {
    private final int[] dx = {0, 0, -1, 1};
    private final int[] dy = {-1, 1, 0, 0};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i=0; i<places.length; i++) {
            boolean bool = search(places[i]);
            if (bool) {
                answer[i] = 1;
            } 
        }
        
        return answer;
    }
    
    private boolean search(String[] map) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                char c = map[i].charAt(j);
                if (c == 'P') {
                    boolean b = bfs(map, i, j);
                    if (!b) return b;
                }
            }
        }
        return true;
    }
    
    private boolean bfs(String[] map, int y, int x) {
        Queue<Coord> q = new LinkedList<>();
        boolean[][] visit = new boolean[5][5];
        q.add(new Coord(y, x, 0));
        
        while (!q.isEmpty()) {
            Coord current = q.poll();
            visit[current.y][current.x] = true;
            if (current.count == 2) continue;
            
            for (int i=0; i<4; i++) {
                int ny = current.y + dy[i];
                int nx = current.x + dx[i];
                if (nx<0 || ny<0 || nx>4 || ny>4) continue;
                
                q.add(new Coord(ny, nx, current.count+1));
                if (map[ny].charAt(nx) == 'P') {
                    if (map[current.y].charAt(current.x) != 'X' && !visit[ny][nx]) 
                        return false;
                }
            }
        }
        return true;
    }
}

class Coord {
    int y; int x; int count;
    
    public Coord(int y, int x, int count) {
        this.y = y;
        this.x = x;
        this.count = count;
    }
}