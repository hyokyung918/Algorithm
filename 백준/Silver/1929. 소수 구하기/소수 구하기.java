import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        boolean[] arr = new boolean[n+1];

        Arrays.fill(arr, true);

        for (int i=2; i*i<=n; i++) {
            if (arr[i]) {
                for (int j=i*i; j<=n; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for (int i=m; i<=n; i++) {
            if (i<2) {
                continue;
            }
            if (arr[i]) {
                System.out.println(i);
            }
        }
    }
}