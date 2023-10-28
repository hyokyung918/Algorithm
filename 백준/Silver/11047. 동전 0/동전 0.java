import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int answer = 0;
        
        int[] value = new int[n];
        
        for (int i=n-1; i>=0; i--) {
            value[i] = Integer.parseInt(br.readLine());
        }
        
        for (int e : value) {
            if (k == 0) {
                break;
            } else if (k < e) {
                continue;
            }
            answer += k / e;
            k %= e;
        }
        
        System.out.println(answer);
    }
}