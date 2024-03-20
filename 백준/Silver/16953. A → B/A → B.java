import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());

        System.out.println(bfs(a, b));
    }

    private static int bfs(long a, long b) {

        Queue<Long> q = new LinkedList<>();
        q.add(a);
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(a, 1);

        while (!q.isEmpty()) {

            long now = q.poll();

            long next = now * 2;
            if (next <= b) {
                map.put(next, map.get(now)+1);
                q.add(next);
            }
            next = now*10 + 1;
            if (next <= b) {
                map.put(next, map.get(now)+1);
                q.add(next);
            }
        }

        if (map.containsKey(b)) {
            return map.get(b);
        }
        return -1;
    }
}