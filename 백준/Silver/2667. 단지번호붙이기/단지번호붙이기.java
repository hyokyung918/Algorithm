import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static int N;
    private static int[][] arr;
    private static boolean[][] visited;

    private static PriorityQueue<Integer> group = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        input();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    group.add(bfs(i, j));
                }
            }
        }

        int size = group.size();
        System.out.println(size);
        for (int i=0; i<size; i++) {
            System.out.println(group.poll());
        }
    }

    private static void input() throws IOException {
        for (int i=0; i<N; i++) {
            String s = br.readLine();

            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
    }

    private static int bfs(int x, int y) {
        Queue<Point2> q = new LinkedList<>();
        q.add(new Point2(x, y));
        visited[x][y] = true;

        int cnt = 1;
        while (!q.isEmpty()) {
            Point2 now = q.poll();

            for (int i=0; i<4; i++) {
                int bx = now.x + dx[i];
                int by = now.y + dy[i];

                if (bx<0 || by<0 || bx>=N || by>=N) continue;
                if (visited[bx][by]) continue;
                if (arr[bx][by] == 0) continue;

                q.add(new Point2(bx, by));
                visited[bx][by] = true;
                cnt++;
            }
        }

        return cnt;
    }
}

class Point2 {

    int x;
    int y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}