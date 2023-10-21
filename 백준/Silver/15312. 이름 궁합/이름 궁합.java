import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String alph = "32123323322122122212111221";
        String a = br.readLine();
        String b = br.readLine();
        String c = "";
        for (int i=0; i<a.length(); i++) {
            c += alph.charAt((int)(a.charAt(i)) - 65);
            c += alph.charAt((int)(b.charAt(i)) - 65);
        }
        System.out.println(dp(c));
    }
    
    public static String dp(String c) {
        if (c.length() == 2) {
            return c;
        }
        String tmp="";
        for (int i=0; i<c.length()-1; i++) {
            int a = Integer.parseInt(String.valueOf(c.charAt(i)));
            int b = Integer.parseInt(String.valueOf(c.charAt(i+1)));
            int t = a + b;
            if (t > 9) t %= 10;
            tmp += String.valueOf(t);
        }
        return dp(tmp);
    }
}