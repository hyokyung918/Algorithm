import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int[][] table, dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        table = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for (int i=1; i<n+1; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=1; j<n+1; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = table[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int answer = dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1-1] + dp[x1-1][y1-1];

            System.out.println(answer);
        }
    }
}