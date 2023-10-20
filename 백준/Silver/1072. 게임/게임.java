import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int z = getPercent(x, y);
        int ans = -1;
        int start = 0;
        int end = (int)1e9;

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (getPercent(x+mid, y+mid) != z) {
                ans = mid;
                end = mid-1;
            } else {
                start = mid+1;
            }
        }

        System.out.println(ans);
    }

    public static int getPercent(int x, int y) {
        return (int) ((long)y*100 / x);
    }
}