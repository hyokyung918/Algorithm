import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] res = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
        long[] val = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        long answer = 0;

        for (int i=0; i<10; i++) {
            if (a.equals(res[i]))
                answer += val[i]*10;
            if (b.equals(res[i]))
                answer += val[i];
        }
        for (int i=0; i<10; i++) {
            if (c.equals(res[i])) {
                answer *= (long)Math.pow(10,i);
                break;
            }
        }
        System.out.println(answer);
    }
}
