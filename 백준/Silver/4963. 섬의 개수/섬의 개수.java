import java.io.*;
import java.util.*;

class Main {

    private static int w, h, answer;
    private static int[][] map;
    private static boolean[][] visit;
    private static StringBuilder sb = new StringBuilder();

    private static int[] dx = {1, -1, 0, 0, 1, 1, -1, -1};
    private static int[] dy = {0, 0, 1, -1, -1, 1, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        while (!s.equals("0 0")) {

            st = new StringTokenizer(s);
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            visit = new boolean[h][w];
            answer = 0;

            for (int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i=0; i<h; i++) {
                for (int j=0; j<w; j++) {
                    if (map[i][j] == 1 && !visit[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
            sb.append(answer).append("\n");
            s = br.readLine();
        }

        System.out.println(sb);
    }

    private static void bfs(int y, int x) {

        Queue<Dot> q = new LinkedList<>();
        q.add(new Dot(x, y));
        visit[y][x] = true;


        while (!q.isEmpty()) {
            Dot now = q.poll();

            for (int i=0; i<8; i++) {
                int mx = now.x + dx[i];
                int my = now.y + dy[i];

                if (mx<0 || my<0 || mx>=w || my>=h) continue;
                if (map[my][mx] == 1 && !visit[my][mx]) {
                    q.add(new Dot(mx, my));
                    visit[my][mx] = true;
                }
            }
        }
    }

    private static class Dot {

        int x;
        int y;

        Dot (int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}