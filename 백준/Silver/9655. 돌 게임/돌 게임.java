import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        if (dp(n, false)) {
            System.out.println("SK");
        } else {
            System.out.println("CY");
        }
    }
    
    private static boolean dp(int num, boolean skWin) {
        
        if (num == 0) {
            return skWin;
        }
        
        if (num > 2) {
            return dp(num - 3, !skWin);
        }
        return dp(num - 1, !skWin);
    }
}