import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder()); 
    
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if (num != 0) {
                q.add(num);
            } else {
                if (q.isEmpty()) {
                    sb.append(0 + "\n");
                } else {
                    sb.append(q.poll() + "\n");
                }
            }
        }
        
        System.out.println(sb);
    }
}