import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        input = br.readLine();

        while (!input.equals("0")) {
            boolean isPalindrome = true;
            for (int i=0; i<input.length()/2; i++) {
                if (input.charAt(i) != input.charAt(input.length()-i-1)) {
                    isPalindrome = false;
                    break;
                }
            }
            if (isPalindrome) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            input = br.readLine();
        }
    }
}