import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[10000];

        for (int i=0; i<n; i++) {
            int input = Integer.parseInt(br.readLine());
            arr[input-1]++;
        }

        for (int i=0; i<10000; i++) {
            while (arr[i]-- > 0) {
                sb.append(i+1 + "\n");
            }
        }
        System.out.println(sb);
    }
}