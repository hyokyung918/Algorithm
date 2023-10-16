import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());

        int last = 0;
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            String[] order = s.split(" ");

            switch (order[0]) {

                case "empty":
                    if (queue.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(queue.peek());
                    }
                    break;

                case "push":
                    int x = Integer.parseInt(order[1]);
                    last = x;
                    queue.offer(x);
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        System.out.println(-1);
                    } else {
                        System.out.println(last);
                    }
                    break;
            }
        }
    }
}
