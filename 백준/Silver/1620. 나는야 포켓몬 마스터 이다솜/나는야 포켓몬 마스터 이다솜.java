import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i=1; i<=n; i++) {
            String s = br.readLine();
            map1.put(i, s);
            map2.put(s, i);
        }
        
        for (int i=0; i<m; i++) {
            String s = br.readLine();
            if (s.charAt(0) < 65) {
                sb.append(map1.get(Integer.parseInt(s)) + "\n");
            } else {
                sb.append(map2.get(s) + "\n");
            }
        }
        
        System.out.println(sb);
    }
}