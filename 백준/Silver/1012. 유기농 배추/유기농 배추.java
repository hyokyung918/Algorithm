import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int T;
    private static int m, n, k;
    private static int[][] arr;
    private static boolean[][] visited;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());

        for (int i=0; i<T; i++) {

            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[m][n];
            visited = new boolean[m][n];

            for (int j=0; j<k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            int ans = 0;
            for (int j=0; j<m; j++) {
                for (int l=0; l<n; l++) {
                    if (arr[j][l] == 1 && !visited[j][l]) {
                        bfs(j, l);
                        ans++;
                    }
                }
            }

            sb.append(ans + "\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new Point(x, y));

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i=0; i<4; i++) {
                int gx = now.x + dx[i];
                int gy = now.y + dy[i];

                if (gx<0 || gy<0 || gx>=m || gy>=n) continue;
                if (arr[gx][gy] == 0) continue;
                if (visited[gx][gy]) continue;

                visited[gx][gy] = true;
                q.add(new Point(gx, gy));
            }
        }
    }
}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}