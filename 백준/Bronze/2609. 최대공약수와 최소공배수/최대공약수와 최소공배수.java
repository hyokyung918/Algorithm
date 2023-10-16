import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int x = 0;

        for (int i=Math.min(a,b); i>0; i--) {
            if (a%i==0 && b%i==0) {
                x = i;
                break;
            }
        }

        int y;
        for (int i = Math.max(a,b); ; i+=x) {
            if (i%a==0 && i%b==0) {
                y = i;
                break;
            }
        }

        System.out.println(x);
        System.out.println(y);
    }
}
