import java.io.*;
import java.util.*;

class Main {
    
    private static int n, m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        
        dfs(0, 1);
        System.out.println(sb);
    }
    
    private static void dfs(int cnt, int now) {
        
        if (cnt == m) {
            
            for (int e : arr) {
                sb.append(e).append(' ');
            }
            sb.append("\n");
            return;
        }
        
        for (int i=1; i<=n; i++) {
            
            arr[cnt] = i;
            dfs(cnt+1, i);
        }
    }
}