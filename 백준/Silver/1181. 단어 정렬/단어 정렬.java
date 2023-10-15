import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<String>();
        ArrayList<String> arr = new ArrayList<String>();

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String s = iter.next();
            int idx = calcIdx(arr, s);
            arr.add(idx, s);
        }

        for (String e : arr)
            System.out.println(e);
    }

    static int calcIdx(ArrayList<String> arr, String s) {
        int idx = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (s.length() < arr.get(i).length()) {
                return idx;
            }
            else if (s.length() > arr.get(i).length()) {
                idx++;
            }
            else {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) < arr.get(i).charAt(j)) {
                        return idx;
                    }
                    if (s.charAt(j) > arr.get(i).charAt(j)) {
                        idx++;
                        break;
                    }
                }
            }
        }
        return idx;
    }
}
