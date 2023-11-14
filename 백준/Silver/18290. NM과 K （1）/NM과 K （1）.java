import java.io.*;
import java.util.*;

public class Main {

    private final static int[] dx = {-1, 1, 0, 0};
    private final static int[] dy = {0, 0, 1, -1};

    private static int n, m, k;
    private static int[][] arr;
    private static boolean[][] visit;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n==1 && m==1) {
            System.out.println(br.readLine());
            return;
        }

        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0, 0);
        System.out.println(answer);
    }

    private static void dfs(int count, int nowX, int nowY, int sum) {

        if (count == k) {
            answer = Math.max(answer, sum);
            return;
        }

        boolean notAdj;
        for (int i=nowX; i<n; i++) {
            for (int j = (nowX == i ? nowY : 0); j<m; j++) {

                if (visit[i][j]) {
                    continue;
                }

                notAdj = true;
                for (int dir=0; dir<4; dir++) {
                    int nx = i + dx[dir];
                    int ny = j + dy[dir];

                    if ((nx>=0 && ny>=0 && nx<n && ny<m) && visit[nx][ny]) {
                        notAdj = false;
                        break;
                    }
                }

                if (notAdj) {
                    visit[i][j] = true;
                    dfs(count+1, i, j, sum+arr[i][j]);
                    visit[i][j] = false;
                }
            }
        }
    }
}