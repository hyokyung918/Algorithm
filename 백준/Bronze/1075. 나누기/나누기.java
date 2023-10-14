import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int answer = 0;

        a -= a%100;
        for (int i=a; i<a+100; i++) {
            if (i%b == 0) {
                answer = i%100;
                break;
            }
        }
        if (answer < 10)
            System.out.println("0" + answer);
        else
            System.out.println(answer);
    }
}
