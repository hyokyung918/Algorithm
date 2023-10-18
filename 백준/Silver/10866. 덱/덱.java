import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> d = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");
            
            boolean isEmpty = d.isEmpty();
            
            switch (arr[0]) {
                case "push_front":
                    int x = Integer.parseInt(arr[1]);
                    d.offerFirst(x);
                    break;
                case "push_back":
                    x = Integer.parseInt(arr[1]);
                    d.offerLast(x);
                    break;
                case "pop_front":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(d.pollFirst());
                    }
                    break;
                case "pop_back":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(d.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(d.size());
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
                        System.out.println(d.peekFirst());
                    }
                    break;
                case "back":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(d.peekLast());
                    }
                    break;
            }
        }
    }
}