import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n==1) {
            System.out.println(1);
            return;
        }
        
        int[] arr = new int[n+1];
        arr[1] = 1;
        arr[2] = 3;
        
        for (int i=3; i<=n; i++) {
            arr[i] = (arr[i-2]*2 + arr[i-1]) % 10007;
        }
        
        System.out.println(arr[n]);
    }
}