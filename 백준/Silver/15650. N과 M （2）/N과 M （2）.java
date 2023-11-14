import java.io.*;
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];

        dfs(1, 0);
        System.out.println(sb);
    }

    private static void dfs(int now, int depth) {

        if (depth == m) {
            for (int e : arr) {
                sb.append(e).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i=now; i<=n; i++) {
            arr[depth] = i;
            dfs(i+1, depth+1);
        }
    }
}