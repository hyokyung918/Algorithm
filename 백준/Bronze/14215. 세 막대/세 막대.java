import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for (int i=0; i<3; i++) {
            q.add(Integer.parseInt(st.nextToken()));
        }
        int max = q.poll();
        int mid = q.poll();
        int min = q.poll();

        int tmp = (mid+min) - 1;
        if (max>tmp) {
            max = tmp;
        }

        System.out.println(max+mid+min);
    }
}