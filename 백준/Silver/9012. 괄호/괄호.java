import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            Queue<Character> q = new LinkedList<>();
            
            boolean isVPS = true;
            for (int j=0; j<s.length(); j++) {
                if (s.charAt(j) == '(') {
                    q.add('(');
                } else {
                    if (q.isEmpty()) {
                        isVPS = false;
                        break;
                    } else {
                        q.poll();
                    }
                }
            }
            
            if (!q.isEmpty()) {
                isVPS = false;
            }
            
            if (isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}