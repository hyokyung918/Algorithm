import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int i=1; i<n+1; i++) {
            q.add(i);
        }

        bw.write("<");

        while (q.size() > 1) {
            for (int i=1; i<k; i++) {
                q.offer(q.poll());
            }
            bw.write(q.poll()+ ", ");
        }

        bw.write(q.poll() + ">");

        br.close();
        bw.flush();
        bw.close();
    }
}
