import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int answer = dp(n);
        System.out.println(answer);
    }
    
    public static int dp(int n) {
        if (n==1)
            return 0;
        if (n==2)
            return 1;
        return (n-1) + (dp(n-1));
    }
}