import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int fin = Integer.parseInt(br.readLine());

        long answer = dp(2, 1, 1, fin);
        System.out.println(answer);
    }

    public static long dp(long cnt, long before, long sum, int fin) {
        if (fin==0) return 0;
        if (fin==1) return 1;
        if (cnt==fin)
            return sum;
        return dp(++cnt, sum, sum+before, fin);
    }
}