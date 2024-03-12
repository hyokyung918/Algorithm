import java.io.*;
import java.util.*;

class Main {
    
    private static int n, m;
    private static int[] arr;
    private static boolean[] visit;
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        visit = new boolean[n+1];
        
        dfs(0, 1);
    }
    
    private static void dfs(int cnt, int now) {
        
        if (cnt == m) {
            
            for (int e : arr) {
                System.out.print(e + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i=1; i<=n; i++) {
            
            if (visit[i]) {
                continue;
            }
            
            arr[cnt] = i;
            visit[i] = true;
            dfs(cnt+1, i);
            visit[i] = false;
        }
    }
}