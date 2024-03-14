import java.io.*;
import java.util.*;

class Main {

    private static boolean isPossible = false;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] board = new int[5][5];

        for (int i=0; i<5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] student = new int[2];
        student[0] = Integer.parseInt(st.nextToken());
        student[1] = Integer.parseInt(st.nextToken());

        solve(0, 0, board, student);

        if (isPossible) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void solve(int move, int apple, int[][] board, int[] student) {

        if (apple == 2) {
            isPossible = true;
            return;
        }
        if (move == 3) {
            return;
        }

        int originalValue = board[student[0]][student[1]];
        for (int i=0; i<4; i++) {

            int mx = student[1] + dx[i];
            int my = student[0] + dy[i];

            if (mx<0 || my<0 || mx>4 || my>4 || board[my][mx] == -1) continue;

            boolean isApple = board[my][mx] == 1 ? true : false;
            if (isApple) apple++;
            board[student[0]][student[1]] = -1;
            int[] tmp = new int[2];
            tmp[0] = my;
            tmp[1] = mx;
            solve(move+1, apple, board, tmp);

            board[student[0]][student[1]] = originalValue;
            if (isApple) apple--;
        }
    }
}