import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int max, min;
        max = min = num;

        for (int i=1; i<n; i++) {
            num= Integer.parseInt(st.nextToken());
            if (max < num) max = num;
            else if (min > num) min = num;
        }

        System.out.println(min + " " + max);
    }
}
