import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int num = 667;
        int count = 1;
        while (count<n) {
            if (String.valueOf(num).contains("666")) {
                count++;
                num++;
            } else {
                num++;
            }
        }
        
        System.out.println(num-1);
    }
}