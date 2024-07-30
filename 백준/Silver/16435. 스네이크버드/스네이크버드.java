import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }

        while (!q.isEmpty()) {
            int fruit = q.poll();
            if (fruit <= l) l++;
        }

        System.out.println(l);
    }
}