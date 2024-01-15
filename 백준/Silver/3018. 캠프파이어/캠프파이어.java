import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<Integer, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int e = Integer.parseInt(br.readLine());

        map.put(1, e);
        for (int i=2; i<=n; i++) {
            map.put(i, 0);
        }

        for (int i=1; i<=e; i++) {

            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            HashSet<Integer> set = new HashSet<>();
            boolean isSY = false;

            for (int j=0; j<k; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if (tmp == 1) {
                    isSY = true;
                    continue;
                }

                set.add(tmp);
            }

            if (isSY) {
                for (int j : set) {
                    if (map.get(j) == i-1) {
                        map.put(j, i);
                    }
                }
            } else {
                for (int j=2; j<=n; j++) {
                    if (map.get(j)==i-1 || set.contains(j)) {
                        map.put(j, i);
                    }
                }
            }

        }

        for (int i=1; i<=n; i++) {
            if (map.get(i) == e) {
                System.out.println(i);
            }
        }
    }
}