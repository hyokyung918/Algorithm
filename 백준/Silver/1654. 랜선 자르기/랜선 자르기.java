import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long[] arr = new long[k];

        long start = 1;
        long finish = 0;

        for (int i=0; i<k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            finish = Math.max(finish, arr[i]);
        }

        long answer = 0;
        while (start <= finish) {
            long cnt = 0;
            long mid = start + (finish-start)/2;

            for (int i=0; i<k; i++) {
                cnt += arr[i]/mid;
            }

            if (n > cnt) {
                finish = mid-1;
            } else {
                answer = Math.max(mid, answer);
                start = mid+1;
            }
        }

        System.out.println(start-1);
    }
}