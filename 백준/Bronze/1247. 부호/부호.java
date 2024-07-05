import java.io.*;
import java.math.BigInteger;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<3; i++) {
            int n = Integer.parseInt(br.readLine());
            BigInteger ans = new BigInteger("0");
            for (int j=0; j<n; j++) {
                BigInteger tmp = new BigInteger(br.readLine());
                ans = ans.add(tmp);
            }
            int compare = ans.compareTo(new BigInteger("0"));
            switch (compare) {
                case 0: System.out.println("0"); break;
                case 1: System.out.println("+"); break;
                case -1: System.out.println("-"); break;
            }
        }
    }
}