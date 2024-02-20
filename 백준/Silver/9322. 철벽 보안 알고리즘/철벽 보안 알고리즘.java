import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int i=0; i<tc; i++) {
            int n = Integer.parseInt(br.readLine());
            List<String> cryptText = new ArrayList<>();
            HashMap<Integer, Integer> cryptOrder = new HashMap<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                cryptText.add(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                String s = st.nextToken();
                cryptOrder.put(cryptText.indexOf(s), j);
            }

            String[] txt = new String[n];
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                txt[j] = new String(st.nextToken());
            }
            for (int j=0; j<n; j++) {
                int idx = cryptOrder.get(j);
                sb.append(txt[idx]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}