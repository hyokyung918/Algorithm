import java.io.*;
import java.util.*;

class Main {

    private static int n, m, start, end;
    private static ArrayList<Node>[] bus;
    private static int[] dist;

    private static class Node {

        int dest, cost;

        Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        bus = new ArrayList[n+1];
        dist = new int[n+1];

        for (int i=1; i<=n; i++) {
            bus[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            bus[a].add(new Node(b, c));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
        System.out.println(dist[end]);
    }

    private static void dijkstra() {

        PriorityQueue<Node> q = new PriorityQueue<Node>
                ((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.add(new Node(start, 0));
        dist[start] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();
            if (dist[now.dest] < now.cost) continue;

            for (int i=0; i<bus[now.dest].size(); i++) {
                Node next = bus[now.dest].get(i);
                if (dist[next.dest] > now.cost + next.cost) {
                    dist[next.dest] = now.cost + next.cost;
                    q.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
    }
}