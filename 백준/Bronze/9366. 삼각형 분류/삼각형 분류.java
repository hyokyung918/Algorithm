import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i=1; i<=t; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(i).append(": ");
            if (a == b && b == c) {
                sb.append("equilateral");
            } else {
                PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
                q.add(a);
                q.add(b);
                q.add(c);
                int max = q.poll();
                int min1 = q.poll();
                int min2 = q.poll();
                if (max < min1 + min2) {
                    if (a==b || a==c || b==c) {
                        sb.append("isosceles");
                    } else {
                        sb.append("scalene");
                    }
                } else {
                    sb.append("invalid!");
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}