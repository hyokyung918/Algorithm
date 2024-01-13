import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] arr = new int[r+w][r+w];
        for (int i=1; i<r+w; i++) {
            for (int j=1; j<=i; j++) {

                if (j==1 || j==i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
            }
        }

        int answer = 0;
        for (int i=r; i<r+w; i++) {
            for (int j=c; j<=i-(r-c); j++) {
                answer += arr[i][j];
            }
        }

        System.out.println(answer);
    }
}