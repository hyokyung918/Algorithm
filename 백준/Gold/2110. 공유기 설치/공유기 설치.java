import java.io.*;
import java.util.*;

public class Main {

    private static int n, c;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int min = 1;
        int max = arr[n-1] - arr[0] + 1;

        System.out.println(search(min, max));
    }

    private static int search(int min, int max) {
        int mid, count, last;

        while (min<=max) {
            mid = (min+max) / 2;
            count = 1;
            last = arr[0];

            for (int a : arr) {
                if (a - last >= mid) {
                    count++;
                    last = a;
                }
            }

            if (count < c) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        return min-1;
    }
}