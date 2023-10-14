import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        for (int i=0; i<=s.length()/10; i++) {
            int startIndex = i*10, finishIndex = (i+1)*10;
            if (i == s.length()/10)
                finishIndex = s.length();
            System.out.println(s.substring(startIndex, finishIndex));
        }
    }
}
