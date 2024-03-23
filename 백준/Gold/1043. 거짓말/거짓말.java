import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static boolean[] people;
    private static Queue<Integer> q = new LinkedList<>();
    private static ArrayList<Integer>[] party;
    private static ArrayList<Integer>[] edge;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        people = new boolean[n+1];
        party = new ArrayList[m];
        edge = new ArrayList[n+1];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        if (x == 0) {
            System.out.println(m);
            return;
        }
        for (int i=0; i<x; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            people[tmp] = true;
            q.add(tmp);
        }

        for (int i=1; i<=n; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int i=0; i<m; i++) {
            party[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            for (int j=0; j<x; j++) {
                party[i].add(Integer.parseInt(st.nextToken()));
            }
            for (int j=0; j<x; j++) {
                for (int k=0; k<x; k++) {
                    if (j==k) continue;
                    edge[party[i].get(j)].add(party[i].get(k));
                }
            }
        }

        bfs();
        int answer = searchParty();
        System.out.println(answer);
    }

    private static void bfs() {

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int e : edge[x]) {
                if (people[e]) continue;
                people[e] = true;
                q.add(e);
            }
        }
    }

    private static int searchParty() {

        int answer = 0;

        for (int i=0; i<m; i++) {
            boolean isPossible = true;
            for (int e : party[i]) {
                if (people[e]) isPossible = false;
            }
            if (isPossible) answer++;
        }

        return answer;
    }
}