import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> q = new PriorityQueue<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int order = Integer.parseInt(br.readLine());

            if (order == 0) {
                if (q.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                        sb.append(q.poll() + "\n");
                }
            } else {
                q.add(order);
            }
        }
        System.out.println(sb);
    }
}