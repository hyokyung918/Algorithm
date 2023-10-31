import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        String pn = "I";
        for (int i=0; i<n; i++) {
            pn += "OI";
        }

        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int count = 0;
        for (int i=0; i<=s.length()-pn.length(); i++) {
            String str = s.substring(i, i+pn.length());
            if (pn.equals(str))
                count++;
        }

        System.out.println(count);
    }
}