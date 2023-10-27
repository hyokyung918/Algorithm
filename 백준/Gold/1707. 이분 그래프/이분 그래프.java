import java.io.*;
import java.util.*;

public class Main {

    static boolean isEnd;
    static int[] visited;

    static List<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjList = new ArrayList[v + 1];
            for (int j = 1; j < v + 1; j++) {
                adjList[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                adjList[a].add(b);
                adjList[b].add(a);
            }

            isEnd = false;
            visited = new int[v + 1];
            boolean endTest = false;

            for (int j = 1; j <= v; j++) {
                if (isEnd) {
                    System.out.println("NO");
                    endTest = true;
                    break;
                }
                if (visited[j] == 0) {
                    dfs(j, 1);
                }
            }

            if (!endTest) {
                System.out.println("YES");
            }
        }
    }

    public static void dfs(int head, int team) {
        if (isEnd) return;

        visited[head] = team;

        for (int num : adjList[head]) {
            if (visited[head] == visited[num]) {
                isEnd = true;
                return;
            } else if (visited[num] == 0) {
                if (visited[head] == 1)
                    dfs(num, 2);
                else
                    dfs(num, 1);
            }
        }
    }
}
