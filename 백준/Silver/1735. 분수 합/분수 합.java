import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int den1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int num2 = Integer.parseInt(st.nextToken());
        int den2 = Integer.parseInt(st.nextToken());

        int div = Math.min(den1, den2);
        for (int i=div; i>0; i--) {
            if (den1%i==0 && den2%i==0) {
                div = i;
                break;
            }
        }

        int den3 = Math.max(den1, den2);
        while (den3%den1!=0 || den3%den2!=0) {
            den3 += div;
        }

        num1 *= den3/den1;
        num2 *= den3/den2;
        int num3 = num1 + num2;

        while (true) {
            div = Math.min(num3, den3);
            for (int i=div; i>0; i--) {
                if (num3%i==0 && den3%i==0) {
                    div = i;
                    break;
                }
            }
            if (div == 1) {
                break;
            }
            num3 /= div;
            den3 /= div;
        }
        System.out.println(num3 + " " + den3);
    }
}