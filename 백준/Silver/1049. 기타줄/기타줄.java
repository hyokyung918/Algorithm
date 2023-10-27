import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int minPack = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;

        for (int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int packCost = Integer.parseInt(st.nextToken());
            int oneCost = Integer.parseInt(st.nextToken());

            if (minPack > packCost)
                minPack = packCost;
            if (minOne > oneCost)
                minOne = oneCost;
        }

        int a = n / 6;
        int b = n % 6;

        int x = minOne * n;
        int y = b==0 ? minPack*a : minPack*(a+1);
        int z = minPack*a + minOne*b;

        int tmp = Math.min(x, y);
        int answer = Math.min(tmp, z);

        System.out.println(answer);
    }
}