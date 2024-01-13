import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[n+1][n+1];
        
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=i; j++) {
                
                if (j==1 || j==i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
                
                if (i==n && j==k)
                    break;
            }
        }
        
        System.out.println(dp[n][k]);
    }
}