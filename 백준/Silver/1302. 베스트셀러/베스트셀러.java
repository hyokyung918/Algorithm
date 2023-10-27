import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (int i=0; i<n; i++) {
            String s = br.readLine();

            if (map.containsKey(s)) {
                map.replace(s, map.get(s)+1);
            } else {
                map.put(s, 1);
            }
        }

        int maxSell = 0;
        String answer = "";
        for (String book : map.keySet()) {
            int sales = map.get(book);
            if (maxSell < sales || (maxSell == sales && book.compareTo(answer) < 0)) {
                maxSell = sales;
                answer = book;
            }
        }
        
        System.out.println(answer);
    }
}