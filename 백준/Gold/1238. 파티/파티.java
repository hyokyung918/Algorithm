import java.io.*;
import java.util.*;

class Main {

    private static class Node{
        int dest, cost;
        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private static int n, m, x, answer = Integer.MIN_VALUE;
    private static ArrayList<Node>[][] edge;
    private static int[][] time;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        edge = new ArrayList[2][n+1];
        time = new int[2][n+1];

        for (int i=1; i<=n; i++) {
            edge[0][i] = new ArrayList<>();
            edge[1][i] = new ArrayList<>();
            if (i==x) continue;
            time[0][i] = Integer.MAX_VALUE;
            time[1][i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edge[0][a].add(new Node(b, c));
            edge[1][b].add(new Node(a, c));
        }

        dijkstra(0);
        dijkstra(1);

        for (int i=1; i<=n; i++) {
            if (i==x) continue;
            answer = Math.max(answer, time[0][i]+time[1][i]);
        }
        System.out.println(answer);
    }

    private static void dijkstra(int i) {

        boolean[] check = new boolean[n + 1];
        PriorityQueue<Node> q = new PriorityQueue<>
                ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Node(x, 0));

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (time[i][now.dest] < now.cost) continue;

            if (!check[now.dest]) {
                check[now.dest] = true;

                for (Node next : edge[i][now.dest]) {
                    if (time[i][next.dest] > now.cost + next.cost && !check[next.dest]) {
                        time[i][next.dest] = now.cost + next.cost;
                        q.add(new Node(next.dest, time[i][next.dest]));
                    }
                }
            }
        }
    }
}