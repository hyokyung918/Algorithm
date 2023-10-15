import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[n][m];

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            for (int j=0; j<m; j++) {
                if (s.charAt(j) == 'W')
                    arr[i][j] = true;
                else arr[i][j] = false;
            }
        }

        ArrayList<Integer> ansArr = new ArrayList<Integer>();
        for (int i=0; i<n-7; i++) {
            for (int j=0; j<m-7; j++) {
                int cnt = 0;
                boolean TF = arr[i][j];

                for (int x=i; x<i+8; x++) {
                    for (int y=j; y<j+8; y++) {
                        if (arr[x][y] != TF) cnt++;
                        TF = !TF;
                    }
                    TF = !TF;
                }

                ansArr.add(cnt);
            }
        }

        int answer = 64;
        for (int i = 0; i < ansArr.size(); i++) {
            int cnt1 = ansArr.get(i);  // 왼쪽 위 칸이 'W'로 시작하는 경우
            int cnt2 = 64 - ansArr.get(i);  // 왼쪽 위 칸이 'B'로 시작하는 경우
            answer = Math.min(answer, Math.min(cnt1, cnt2));
        }
        System.out.println(answer);
    }
}
