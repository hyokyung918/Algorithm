import java.io.*;
import java.util.*;

public class Main {

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int m, n;
    private static int[][] arr;
    private static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                arr[i][j] = tomato;

                if (tomato == 1) {
                    q.add(new Integer[]{i, j});
                }
            }
        }

        System.out.println(bfs());
    }

    private static int bfs() {

        while (!q.isEmpty()) {
            Integer[] t = q.poll();
            int x = t[0];
            int y = t[1];

            for (int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;
                if (arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[x][y] + 1;
                    q.add(new Integer[]{nx, ny});
                }
            }
        }

        int max = Integer.MIN_VALUE;
        if (checkZero()) {
            return -1;
        } else {
            for (int i=0; i<n; i++) {
                for (int j=0; j<m; j++) {
                    if (max < arr[i][j]) {
                        max = arr[i][j];
                    }
                }
            }

            return max-1;
        }
    }

    private static boolean checkZero() {
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (arr[i][j] == 0)
                    return true;
            }
        }
        return false;
    }
}