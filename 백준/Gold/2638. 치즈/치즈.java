import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int[][] map;
    private static boolean[][] visit;
    private static ArrayList<Dot> cheeseList;
    private static int cheeseCnt = 0;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        cheeseList = new ArrayList<>();

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCnt++;
                    cheeseList.add(new Dot(i, j));
                }
            }
        }

        int answer=0;

        while (cheeseCnt > 0) {
            answer++;
            visit = new boolean[n][m];
            init(0, 0);
            melt();
        }

        System.out.println(answer);
    }

    private static void init(int y, int x) {

        visit[y][x] = true;
        map[y][x] = 2;

        for (int i=0; i<4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];

            if (mx<0 || my<0 || mx>=m || my>=n) continue;
            if (visit[my][mx] || map[my][mx] == 1) continue;

            init(my, mx);
        }
    }

    private static void melt() {

        for (int i=0; i<cheeseList.size(); i++) {
            int x = cheeseList.get(i).x;
            int y = cheeseList.get(i).y;

            int cnt = 0;
            for (int j=0; j<4; j++) {
                int mx = x + dx[j];
                int my = y + dy[j];

                if (map[my][mx] == 2) cnt++;
            }

            if (cnt>1) {
                map[y][x] = 0;
                cheeseCnt--;
                cheeseList.remove(i);
                i--;
            }
        }
    }
}

class Dot {
    int x, y;
    
    Dot(int y, int x) {
        this.x = x;
        this.y = y;
    }
}