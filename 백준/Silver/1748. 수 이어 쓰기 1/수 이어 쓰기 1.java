import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        while (n>1) {
            String s = String.valueOf(n);
            int i = s.length();
            int range = n - (int)Math.pow(10, i-1) + 1;
            cnt += range * i;
            n -= range;
        }

        System.out.println(cnt);
    }
}