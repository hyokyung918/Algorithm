import java.io.*;
import java.util.*;
import java.math.*;

class Main {

    private static int n;
    private static int[][] rgb, dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        rgb = new int[n][3];
        dp = new int[n][3];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }
        
        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];
        
        for (int i=1; i<n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + rgb[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + rgb[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + rgb[i][2];
        }
        
        int answer = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(answer);
    }
}