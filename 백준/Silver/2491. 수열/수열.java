import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int[] arr;
    private static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        increaseDp(n-1, 1);
        decreaseDp(n-1, 1);
        System.out.println(answer);
    }

    private static void increaseDp(int now, int count) {

        if (now==0) {
            answer = Math.max(answer, count);
            return;
        }

        if (arr[now] >= arr[now-1]) {
            increaseDp(now-1, count+1);
        } else {
            answer = Math.max(answer, count);
            increaseDp(now-1, 1);
        }
    }

    private static void decreaseDp(int now, int count) {

        if (now==0) {
            answer = Math.max(answer, count);
            return;
        }

        if (arr[now] <= arr[now-1]) {
            decreaseDp(now-1, count+1);
        } else {
            answer = Math.max(answer, count);
            decreaseDp(now-1, 1);
        }
    }
}