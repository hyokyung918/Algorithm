import java.io.*;
import java.util.*;

public class Main {
    
    private static int n, m, r;
    private static ArrayList<Integer>[] list;
    private static int[] visit;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        visit = new int[n+1];
        for (int i=1; i<=n; i++) {
            list[i] = new ArrayList<>();
        }
        
        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (int i=1; i<=n; i++) 
            Collections.sort(list[i], Collections.reverseOrder());
        
        bfs();
        
        for (int i=1; i<n+1; i++) {
            System.out.println(visit[i]);
        }
    }
    
    private static void bfs() {
        
        Queue<Integer> q = new LinkedList<>();
        q.add(r);
        int count = 1;
        visit[r] = count++;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : list[now]) {
                if (visit[next] != 0) continue;
                
                q.add(next);
                visit[next] = count++;
            }
        }
    }
}