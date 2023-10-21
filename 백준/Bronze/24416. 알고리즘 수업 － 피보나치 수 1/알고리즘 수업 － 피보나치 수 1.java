import java.io.*;

public class Main {
    public static int cnt = 0;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int s = fib(n);
        int c = n-2;
        System.out.println(cnt + " " + c);
    }
    
    public static int fib(int n) {
        if (n==1 || n==2) {
            cnt++;
            return 1;
        }
        return fib(n-1) + fib(n-2);
    }
}