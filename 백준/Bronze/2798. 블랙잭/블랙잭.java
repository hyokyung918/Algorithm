import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int bench = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (int i=0; i<n; i++) {
            int sum = list.get(i);
            for (int j=0; j<n; j++) {
                if (i == j) continue;
                sum += list.get(j);
                for (int k=0; k<n; k++) {
                    if (i==k || j==k) continue;
                    sum += list.get(k);
                    arr.add(sum);
                    sum -= list.get(k);
                }
                sum -= list.get(j);
            }
        }
        Collections.sort(arr);

        for (int i=arr.size()-1; i>=0; i--) {
            if (arr.get(i) <= bench) {
                System.out.println(arr.get(i));
                break;
            }
        }
    }
}
