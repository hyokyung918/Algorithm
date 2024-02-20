import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j=1; j<10; j++) {
                map.put(j, 0);
            }

            Queue<Integer> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                int x = Integer.parseInt(st.nextToken());
                queue.add(x);
                map.replace(x, map.get(x)+1);
            }

            int tmp = 0;
            int cnt = 0;
            while (true) {

                int x = queue.poll();
                boolean canRemove = true;

                for (int j=x+1; j<10; j++) {
                    if (map.get(j) > 0) {
                        canRemove = false;
                        break;
                    }
                }

                if (tmp == m) {
                    if (canRemove) {
                        cnt++;
                        break;
                    } else {
                        queue.add(x);
                        m = queue.size()-1;
                        tmp = 0;
                    }
                } else {
                    if (canRemove) {
                        map.replace(x, map.get(x)-1);
                        cnt++;
                    } else {
                        queue.add(x);
                    }
                    tmp++;
                }
            }

            System.out.println(cnt);
        }
    }
}