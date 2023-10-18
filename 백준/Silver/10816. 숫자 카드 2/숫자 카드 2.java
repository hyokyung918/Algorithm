import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<m; i++) {
            int value = Integer.parseInt(st.nextToken());

            int lowIndex = findLowerIndex(arr, value);
            int highIndex = findHigherIndex(arr, value);
            int cnt = highIndex - lowIndex;
            
            bw.write(cnt + " ");
        }
        br.close();
        bw.close();
    }

    public static int findLowerIndex(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length;

        while (lo < hi) {
            int mid = lo + (hi-lo)/2;

            if (arr[mid] >= value) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static int findHigherIndex(int[] arr, int value) {
        int lo = 0;
        int hi = arr.length;

        while (lo<hi) {
            int mid = lo + (hi-lo)/2;

            if (arr[mid] > value) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}