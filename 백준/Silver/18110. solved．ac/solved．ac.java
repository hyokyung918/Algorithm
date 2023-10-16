import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int delCnt = Math.round(n*(float)0.15);

        if ((n-delCnt*2) == 0) {
            System.out.println(0);
        } else {
            int sum = 0;
            for (int i=delCnt; i<n-delCnt; i++) {
                sum += arr[i];
            }

            double avg = (double)sum / (n-delCnt*2);
            System.out.println(Math.round(avg));
        }
    }
}
