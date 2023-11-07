import java.io.*;
import java.util.*;

public class Main {
    
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    
    private static int n;
    private static int[] arr;
    private static boolean[] check = new boolean[100000*20 + 1];
    private static int answer = 1;
    
    public static void main(String[] args) throws IOException {
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dfs(0, 0);
        
        while (check[answer]) {
            answer++;
        }
        
        System.out.println(answer);
    }
    
    private static void dfs(int idx, int sum) {
        if (idx == n) {
            check[sum] = true;
        } else {
            dfs(idx+1, sum+arr[idx]);
            dfs(idx+1, sum);
        }
    }
}