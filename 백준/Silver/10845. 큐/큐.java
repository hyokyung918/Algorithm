import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList();
        int n = Integer.parseInt(br.readLine());
        
        int update = 0;
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            
            boolean isEmpty = q.isEmpty();
            switch (arr[0]) {
                case "push":
                    int num =Integer.parseInt(arr[1]);
                    q.offer(num);
                    update = num;
                    break;
                case "pop":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.poll());
                    }
                    break;
                case "size":
                    System.out.println(q.size());
                    break;
                case "empty":
                    if (isEmpty) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "front":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(q.peek());
                    }
                    break;
                case "back":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(update);
                    }
                    break;
            }
        }
    }
}