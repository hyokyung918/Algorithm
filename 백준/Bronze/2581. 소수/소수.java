import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int min = -1;
        for (int i=m; i<=n; i++) {
            if (i==1) continue;

            boolean isPrime = true;
            for (int j=2; j*j<=i; j++) {
                if (i%j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                if (sum == 0) min = i;
                sum += i;
            }
        }

        if (sum != 0) {
            System.out.println(sum);
        }
        System.out.println(min);
    }
}