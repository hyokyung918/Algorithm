import java.io.*;
import java.util.*;

public class Main {
    
    static int node;
    static int link;
    static int count = 0;
    
    static boolean[] check;
    static int[][] arr;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        node = Integer.parseInt(br.readLine());
        link = Integer.parseInt(br.readLine());
        
        check = new boolean[node+1];
        arr = new int[node+1][node+1];
        
        for (int i=0; i<link; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            arr[a][b] = arr[b][a] = 1;
        }
        
        dfs(1);
        System.out.println(count);
    }
    
    public static void dfs(int start) {
        check[start] = true;
        
        for (int i=1; i<=node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                count++;
                dfs(i);
            }
        }
    }
}