import java.io.*;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int l = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        BigInteger n = new BigInteger("0");
        for (int i=0; i<l; i++) {
            n = n.add(BigInteger.valueOf(31).pow(i).multiply(BigInteger.valueOf(s.charAt(i) - 96)));
        }
                
        n = n.mod(BigInteger.valueOf(1234567891));
        System.out.println(n);
    }
}