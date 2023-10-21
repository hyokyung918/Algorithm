import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=1; i<n+1; i++) {
            q.add(i);
        }

        while (q.size() > 0) {
            System.out.printf(q.poll() + " ");
            if (!q.isEmpty()) {
                q.add(q.poll());
            }
        }
    }
}