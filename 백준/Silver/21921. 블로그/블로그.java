import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int max = 0;
        int maxCount = 0;
        int sum = 0;
        
        for (int i=0; i<n-x+1; i++) {
            
            if (i==0) {
                for (int j=0; j<x; j++) {
                    sum += arr[j];
                }
                max = sum;
                maxCount++;
                continue;
            }
            
            sum -= arr[i-1];
            sum += arr[i+x-1];
            if (max == sum) {
                maxCount++;
            } else if (sum > max) {
                max = sum;
                maxCount = 1;
            }
        }
        
        if (max == 0) {
            System.out.println("SAD");
            return;
        }
        System.out.println(max);
        System.out.println(maxCount);
    }
}