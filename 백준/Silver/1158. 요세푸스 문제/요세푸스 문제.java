import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        for (int i=1; i<=n; i++) {
            q.add(i);
        }
        
        int counter = 1;
        bw.write("<");
        while (q.size() > 1) {
            if (counter < k) {
                q.add(q.poll());
                counter++;
            } else {
                bw.write(q.poll() + ", ");
                counter = 1;
            }
        }
        bw.write(q.poll() + ">");
        
        br.close();
        bw.close();
    }
}