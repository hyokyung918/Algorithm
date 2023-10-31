import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static PriorityQueue<Integer> positiveQueue = new PriorityQueue<>();
    private static PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num != 0) {
                if (num > 0) {
                    positiveQueue.add(num);
                } else {
                    negativeQueue.add(num);
                }
            } else {
                if (positiveQueue.isEmpty() && negativeQueue.isEmpty()) {
                    sb.append(0 + "\n");
                } else if (positiveQueue.isEmpty()) {
                    sb.append(negativeQueue.poll() + "\n");
                } else if (negativeQueue.isEmpty()) {
                    sb.append(positiveQueue.poll() + "\n");
                } else {
                    int a = positiveQueue.peek();
                    int b = -negativeQueue.peek();

                    if (a < b) {
                        sb.append(positiveQueue.poll() + "\n");
                    } else {
                        sb.append(negativeQueue.poll() + "\n");
                    }
                }
            }
        }

        System.out.println(sb);
    }
}