import java.io.*;
import java.util.*;

class Main {

    private static int n, k;
    private static int[] map = new int[100001];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for (int i=0; i<map.length; i++) {
            map[i] = Integer.MAX_VALUE;
        }

        search();
        System.out.println(map[k]);
    }

    private static void search() {

        Queue<Check> q = new LinkedList<>();
        q.add(new Check(n, 0));
        map[n] = 0;

        while (!q.isEmpty()) {
            int coordinate = q.peek().coord;
            int count = q.poll().cnt;

            if (coordinate+1 < map.length) {
                if (map[coordinate+1] > count+1) {
                    map[coordinate+1] = count+1;
                    q.add(new Check(coordinate+1, count+1));
                }
            }
            if (coordinate-1 >= 0) {
                if (map[coordinate-1] > count+1) {
                    map[coordinate-1] = count+1;
                    q.add(new Check(coordinate-1, count+1));
                }
            }
            if (coordinate*2 < map.length) {
                if (map[coordinate*2] > count) {
                    map[coordinate*2] = count;
                    q.add(new Check(coordinate*2, count));
                }
            }
        }
    }

    private static class Check {

        int coord, cnt;

        Check(int coord, int cnt) {
            this.coord = coord;
            this.cnt = cnt;
        }
    }
}