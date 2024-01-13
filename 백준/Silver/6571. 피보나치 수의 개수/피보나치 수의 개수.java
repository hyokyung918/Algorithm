import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        List<BigInteger> dp = new ArrayList<>();
        dp.add(new BigInteger("1"));
        dp.add(new BigInteger("2"));

        while (!s.equals("0 0")) {

            String[] arr = s.split(" ");
            BigInteger a = new BigInteger(arr[0]);
            BigInteger b = new BigInteger(arr[1]);

            while (dp.get(dp.size()-1).compareTo(b) <= 0) {
                dp.add(new BigInteger(String.valueOf(dp.get(dp.size()-1).add(dp.get(dp.size()-2)))));
            }

            int cnt = 0;
            for (int i=dp.size()-1; i>=0; i--) {
                if (dp.get(i).compareTo(a) < 0)
                    break;
                if (dp.get(i).compareTo(b) < 1)
                    cnt++;
            }

            System.out.println(cnt);

            s = br.readLine();
        }
    }
}