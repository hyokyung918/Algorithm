import java.util.*;

class Solution {
    public int n, m, k;
    public int[] dx = {1, 0, 0, -1};
    public int[] dy = {0, -1, 1, 0};
    public char[] nch = {'d', 'l', 'r', 'u'};
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n; this.m = m; this.k = k;
        
        int dist = Math.abs(x-r) + Math.abs(y-c);
        if (dist > k || (k-dist) % 2 == 1) return "impossible";
        
        StringBuilder answer = new StringBuilder();
        if (dfs(x, y, r, c, 0, answer)) {
            return answer.toString();
        } return "impossible";
    }
    
    public boolean dfs(int x, int y, int r, int c, int count, StringBuilder path) {
        if (count == k) return x==r && y==c;
        
        int dist = Math.abs(x-r) + Math.abs(y-c);
        if (dist>k-count || ((k-count)-dist) %2 == 1) return false;
        
        for (int i=0; i<4; i++) {
            int nx = x+dx[i]; int ny = y+dy[i];
            
            if (nx<1 || ny<1 || nx>n || ny>m) continue;
            path.append(nch[i]);
            if (dfs(nx, ny, r, c, count+1, path)) return true;
            path.deleteCharAt(path.length() - 1);
        }
        
        return false;
    }
}