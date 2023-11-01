import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int[] stairs;
    private static Integer[] dpArr;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        stairs = new int[n+1];
        dpArr = new Integer[n+1];

        for (int i=1; i<n+1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }
        dpArr[0] = stairs[0];
        dpArr[1] = stairs[1];
        if (n >= 2) {
            dpArr[2] = stairs[1] + stairs[2];
        }

        System.out.println(dp(n));
    }

    private static int dp(int n) {

        if (dpArr[n] == null) {
            dpArr[n] = Math.max(dp(n-2), dp(n-3) + stairs[n-1]) + stairs[n];
        }

        return dpArr[n];
    }
}