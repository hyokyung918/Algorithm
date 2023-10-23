import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> hash = new HashMap<String, Integer>();

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            hash.put(s, 1);
        }

        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i<m; i++) {
            String s = br.readLine();
            if (hash.get(s) != null) {
                list.add(s);
            }
        }
        list.sort(null);
        System.out.println(list.size());
        for (String s : list) {
            System.out.println(s);
        }
    }
}