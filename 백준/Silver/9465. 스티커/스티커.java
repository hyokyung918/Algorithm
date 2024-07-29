import java.io.*;
import java.util.*;
import java.math.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        
        for (int tc=0; tc<t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n];
            int[][] dp = new int[2][n];
            
            for (int i=0; i<2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<n; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[0][0] = sticker[0][0];
            dp[1][0] = sticker[1][0];
            if (n == 1) {
                int answer = Math.max(dp[0][n-1], dp[1][n-1]);
                System.out.println(answer);
                continue;
            }
            dp[0][1] = dp[1][0] + sticker[0][1];
            dp[1][1] = dp[0][0] + sticker[1][1];
            
            for (int i=2; i<n; i++) {
                dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + sticker[0][i];
                dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + sticker[1][i];
            }
            
            int answer = Math.max(Math.max(dp[0][n-1], dp[1][n-1]), 
                                  Math.max(dp[0][n-2], dp[1][n-2]));
            System.out.println(answer);
        }
    }
}