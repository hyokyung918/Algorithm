import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<n; i++) {
            
            int x = Integer.parseInt(st.nextToken());
            arr1[i] = x;
            arr2[i] = x;
        }
        Arrays.sort(arr2);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int e : arr2) {
            if (!map.containsKey(e)) {
                map.put(e, cnt);
                cnt++;
            }
        }
        
        StringBuilder sb= new StringBuilder();
        for (int e : arr1) {
            sb.append(map.get(e) + " ");
        }
        
        System.out.println(sb);
    }
}