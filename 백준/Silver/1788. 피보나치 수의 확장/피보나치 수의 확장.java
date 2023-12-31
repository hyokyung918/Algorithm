import java.io.*;
import java.util.Arrays;

public class Main {
    
    private static int[] dp;
    private static final int mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n>0) {
            System.out.println(1);
        } else if (n<0) {
            n = -n;
            
            if (n%2 == 0) {
                System.out.println(-1);
            } else {
                System.out.println(1);
            }
        } else {
            System.out.println(0);
        }
        
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(fibo(n));
    }

    private static int fibo(int x) {
        if (x==0) return 0;
        if (x==1 || x==2) return 1;
        if (dp[x] != -1) return dp[x];
        return dp[x] = (fibo(x-1)%mod + fibo(x-2)%mod) % mod;
    }
}