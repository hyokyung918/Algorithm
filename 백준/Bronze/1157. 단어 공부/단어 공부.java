import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] count = new int[26];
        for (int i=0; i<26; i++) {
            count[i] = 0;
        }
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c<91)
                count[c-65]++;
            else
                count[c-97]++;
        }
        int max = -1;
        char ch = '?';
        for (int i=0; i<26; i++) {
            if (max < count[i]) {
                max = count[i];
                ch = (char)(i+65);
            }
            else if (max == count[i]) {
                ch = '?';
            }
        }
        System.out.println(ch);
    }
}
