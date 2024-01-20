import java.io.*;
import java.util.*;

public class Main {

    private static int n;
    private static int k;
    private static int[] map = new int[100001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        map[n] = 1; // 시작 지점의 거리는 1로 초기화

        while (!queue.isEmpty()) {
            int x = queue.poll();

            if (x == k) {
                return map[x] - 1; // 시작 지점의 거리를 1로 초기화했으므로, 결과에서 1을 빼줌
            }

            if (x*2 < 100001 && map[x*2] == 0) {
                map[x*2] = map[x] + 1;
                queue.add(x*2);
            }
            if (x+1 < 100001 && map[x+1] == 0) {
                map[x+1] = map[x] + 1;
                queue.add(x+1);
            }
            if (x-1 >= 0 && map[x-1] == 0) {
                map[x-1] = map[x] + 1;
                queue.add(x-1);
            }
        }

        return -1; // 도달할 수 없는 경우
    }

}