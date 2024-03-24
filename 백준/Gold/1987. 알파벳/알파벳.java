import java.io.*;
import java.util.*;

class Main {

    private static int r, c, answer = 0;
    private static char[][] map;
    private static boolean[][] check;
    private static ArrayList<Character> list = new ArrayList<>();

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        check = new boolean[r][c];

        for (int i=0; i<r; i++) {
            String s = br.readLine();
            for (int j=0; j<c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        check[0][0] = true;
        list.add(map[0][0]);
        bt(0, 0);
        System.out.println(answer);
    }

    private static void bt(int x, int y) {

        int isEnd = 0;

        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            boolean isPossible = true;

            if (nx<0 || ny<0 || nx>=r || ny>=c || check[nx][ny]) {
                isEnd++;
                continue;
            }
            for (char c : list) {
                if (c == map[nx][ny]) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                check[nx][ny] = true;
                list.add(map[nx][ny]);
                bt(nx, ny);
                check[nx][ny] = false;
                list.remove(list.size()-1);
            } else {
                isEnd++;
            }
        }

        if (isEnd == 4) {
            answer = Math.max(answer, list.size());
        }
    }
}