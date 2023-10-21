import java.io.*;

public class Main {
    public static boolean b = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(dp(n));
    }

    public static int dp(int n) {
        if (n%5 == 0) {
            return n/5;
        } else if (b && n%2 == 0) {
            return n/2;
        }

        int tmp = 0;
        for (int i=n/5; i>=0; i--) {
            if ((n-(i*5))%2 == 0) {
                b = true;
                tmp = i*5;
                break;
            }
            if (i==0) {
                return -1;
            }
        }
        return dp(tmp) + dp(n - tmp);
    }
}