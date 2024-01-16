import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i=0; i<n; i++) {
            queue.add(Integer.parseInt(st.nextToken()));
        }
        
        int[] arr = new int[n];
        arr[0] = queue.poll();
        int sum = arr[0];
        
        for (int i=1; i<n; i++) {
            arr[i] = arr[i-1] + queue.poll();
            sum += arr[i];
        }
        
        System.out.println(sum);
    }
}