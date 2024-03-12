import java.io.*;
import java.util.*;

class Main {
    
    private static int n, m;
    private static int[] arr;
    private static int[] answer;
    private static boolean[] visit;
    private static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        visit = new boolean[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        dfs(0);
        System.out.println(sb);
    }
    
    private static void dfs(int cnt) {
        
        if (cnt == m) {
            
            for (int e : answer) {
                sb.append(e).append(' ');
            }
            sb.append("\n");
            return;
        }
        
        for (int i=0; i<n; i++) {
            
            if (visit[i]) {
                continue;
            }
            
            visit[i] = true;
            answer[cnt] = arr[i];
            dfs(cnt+1);
            visit[i] = false;
        }
    }
}