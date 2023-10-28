import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, String> map = new HashMap<>();
        
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            String[] a = s.split(" ");
            map.put(a[0], a[1]);
        }
        
        for (int i=0; i<m; i++) {
            String s = br.readLine();
            String ans = map.get(s);
            sb.append(ans + "\n");
        }
        
        System.out.println(sb);
    }
}