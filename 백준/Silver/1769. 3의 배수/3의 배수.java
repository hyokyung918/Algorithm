import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        int count = 0;
        while (s.length() > 1) {
            int n = 0;
            for (int i=0; i<s.length(); i++) {
                n += Integer.parseInt(String.valueOf(s.charAt(i)));
            }
            s = String.valueOf(n);
            count++;
        }
        boolean isMultiple = Integer.parseInt(s) % 3 == 0;
        
        System.out.println(count);
        if (isMultiple) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}