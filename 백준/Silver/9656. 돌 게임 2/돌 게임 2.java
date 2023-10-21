import java.io.*;

public class Main {
    static boolean b = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp(n);
        
        if (b) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
    
    public static void dp(int n) {
        if (n == 0) return;
        
        if (b) b = false;
        else b = true;
        
        if (n > 2) n -= 3;
        else n -= 1;
        dp(n);
    }
}