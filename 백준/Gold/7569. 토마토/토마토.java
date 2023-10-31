import java.io.*;
import java.util.*;

public class Main {

    private static int[] dh = {+1, -1, 0, 0, 0, 0};
    private static int[] dx = {0, 0, +1, -1, 0, 0};
    private static int[] dy = {0, 0, 0, 0, +1, -1};

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int m, n, h;
    private static int[][][] arr;
    private static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][n][m];

        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k=0; k<m; k++) {
                    int tomato = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = tomato;

                    if (tomato == 1) {
                        q.add(new Integer[]{i, j, k});
                    }
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            Integer[] t = q.poll();
            int u = t[0];
            int x = t[1];
            int y = t[2];

            for (int i=0; i<6; i++) {
                int nh = u + dh[i];
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nh<0 || nh>=h || nx<0 || nx>=n || ny<0 || ny>=m) {
                    continue;
                }
                if (arr[nh][nx][ny] == 0) {
                    arr[nh][nx][ny] = arr[u][x][y] + 1;
                    q.add(new Integer[]{nh, nx, ny});
                }
            }
        }

        if (findZero()) {
            return -1;
        } else {
            int max = Integer.MIN_VALUE;

            for (int i=0; i<h; i++) {
                for (int j=0; j<n; j++) {
                    for (int k=0; k<m; k++) {
                        if (arr[i][j][k] > max) {
                            max = arr[i][j][k];
                        }
                    }
                }
            }

            return max - 1;
        }
    }

    private static boolean findZero() {

        for (int i=0; i<h; i++) {
            for (int j=0; j<n; j++) {
                for (int k=0; k<m; k++) {
                    if (arr[i][j][k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
