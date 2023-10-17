import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] arr1 = new int[n];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr1[i] = value;
        }
        Arrays.sort(arr1);
        
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) {
            int num = Integer.parseInt(st.nextToken());
            System.out.println(findNum(arr1, num, 0, n-1));
        }
    }
    
    public static int findNum(int[] arr1, int num, int start, int finish) {
        int mid = 0;
        
        if (start <= finish) {
            mid = (start+finish) / 2;
            
            if (num == arr1[mid]) {
                return 1;
            } else if (num < arr1[mid]) {
                return findNum(arr1, num, 0, mid-1);
            } else {
                return findNum(arr1, num, mid+1, finish);
            }
        }
        
        return 0;
    }
}