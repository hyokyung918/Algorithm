import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static char[][] campus;
    private static boolean[][] visit;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        campus = new char[n][m];
        visit = new boolean[n][m];
        int doyeonX = 0, doyeonY = 0;

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                campus[i][j] = s.charAt(j);
                if (campus[i][j] == 'I'){
                    doyeonX = j;
                    doyeonY = i;
                }
            }
        }

        int answer = bfs(doyeonY, doyeonX);

        if (answer == 0) {
            System.out.println("TT");
        } else {
            System.out.println(answer);
        }
    }

    private static int bfs(int y, int x) {

        int answer = 0;
        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(y, x));
        visit[y][x] = true;

        while (!q.isEmpty()) {
            Dot now = q.poll();

            for (int i=0; i<4; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (mx<0 || my<0 || mx>=m || my>=n) continue;
                if (campus[my][mx] == 'X') continue;
                if (!visit[my][mx]) {
                    q.add(new Dot(my, mx));
                    visit[my][mx] = true;
                    if (campus[my][mx] == 'P') answer++;
                }
            }
        }

        return answer;
    }

    private static class Dot {

        int x, y;

        Dot(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}