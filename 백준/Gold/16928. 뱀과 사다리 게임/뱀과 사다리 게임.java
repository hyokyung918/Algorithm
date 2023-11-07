import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int[] arr = new int[101];
    private static boolean[] visited = new boolean[101];
    private static int[] count = new int[101];
    private static Queue<Integer> q = new LinkedList<>();

    private static int n, m;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i=0; i<n+m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u] = v;
        }

        System.out.println(dfs());
    }

    private static int dfs() {

        q.add(1);
        count[1] = 0;
        visited[1] = true;

        while (!q.isEmpty()) {

            int now = q.poll();

            if (now == 100) {
                return count[now];
            }

            for (int i=1; i<=6; i++) {
                int next = now + i;

                if (next>100 || visited[next])
                    continue;
                
                if (arr[next] != 0) {
                    if (!visited[arr[next]]) {
                        q.add(arr[next]);
                        visited[arr[next]] = true;
                        count[arr[next]] = count[now]+1;
                    }
                } else {
                    q.add(next);
                    count[next] = count[now]+1;
                    visited[next] = true;
                }
            }
        }
        return 0;
    }
}