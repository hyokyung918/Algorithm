import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = n-k;
        int answer = 1;

        for (int i=n-1; i>1; i--) {
            n *= i;
        }
        for (int i=k-1; i>1; i--) {
            k *= i;
        }
        for (int i=x-1; i>1; i--) {
            x *= i;
        }

        if (k != 0 && x != 0) {
            answer = n / (k*x);
        }

        System.out.println(answer);
    }
}