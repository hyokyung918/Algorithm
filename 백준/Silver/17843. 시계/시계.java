import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {

            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            double oa, ob, oc;
            oc = s*6;
            ob = m*6 + 0.1*s;
            oa = h*30 + 0.5*m + s/120.0;

            double ca, cb, cc;
            ca = Math.max(oa, ob) - Math.min(oa, ob);
            if (ca > 180) ca = 360-ca;
            cb = Math.max(ob, oc) - Math.min(ob, oc);
            if (cb > 180) cb = 360-cb;
            cc = Math.max(oa, oc) - Math.min (oa, oc);
            if (cc > 180) cc = 360-cc;

            System.out.println(Math.min(Math.min(ca, cb), cc));
        }
    }
}