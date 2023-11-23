import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] arr = new long[101];

            arr[1] = arr[2] = arr[3] = 1;
            arr[4] = arr[5] = 2;

            for (int j=6; j<=n; j++) {
                arr[j] = arr[j-1] + arr[j-5];
            }

            System.out.println(arr[n]);
        }
    }
}