import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        long n = 0;
        for (int i=0; i<l; i++) {
            n += Math.pow(31, i) * ((int)s.charAt(i) - 96);
        }
        
        System.out.println(n);
    }
}