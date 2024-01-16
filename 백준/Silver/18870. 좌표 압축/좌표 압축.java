import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i=0; i<n; i++) {
            
            int x = Integer.parseInt(st.nextToken());
            
            arr[i] = x;
            set.add(x);
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        for (int e : list) {
            map.put(e, cnt);
            cnt++;
        }
        
        StringBuilder sb= new StringBuilder();
        for (int e : arr) {
            sb.append(map.get(e) + " ");
        }
        
        System.out.println(sb);
    }
}