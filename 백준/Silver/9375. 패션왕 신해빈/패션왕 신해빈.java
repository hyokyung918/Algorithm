import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<String, Integer>();

            for (int j=0; j<n; j++) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String s = st.nextToken();

                if (map.containsKey(s)) {
                    int c = map.get(s);
                    map.replace(s, c+1);
                } else {
                    map.put(s, 1);
                }
            }

            int answer = 1;

            for (int e : map.values()) {
                answer *= (e+1);
            }
            
            answer--;

            System.out.println(answer);
        }
    }
}