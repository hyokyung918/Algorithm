import java.io.*;
import java.util.*;

public class Main {
    
    private static int n, k;
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        System.out.println(search(1, k));
    }
    
    private static int search(int min, int max) {
        int mid, count;
        
        while (min <= max) {
            mid = (min+max) / 2;
            count = 0;
            
            for (int i=1; i<=n; i++) {
                count += Math.min(mid/i, n);
            }
            
            if (count<k) {
                min = mid+1;
            } else {
                max = mid-1;
            }
        }
        return min;
    }
}