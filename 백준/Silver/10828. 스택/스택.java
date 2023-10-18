import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            String[] arr = str.split(" ");

            boolean isEmpty = s.isEmpty();
            switch (arr[0]) {
                case "push":
                    s.add(Integer.parseInt(arr[1]));
                    break;
                case "pop":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        System.out.println(s.pop());
                    }
                    break;
                case "size":
                    System.out.println(s.size());
                    break;
                case "empty":
                    if (isEmpty) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;
                case "top":
                    if (isEmpty) {
                        System.out.println(-1);
                    } else {
                        int num = s.pop();
                        System.out.println(num);
                        s.add(num);
                    }
                    break;
            }
        }
    }
}