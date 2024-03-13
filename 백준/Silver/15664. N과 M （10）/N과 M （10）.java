import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int[] input, output;
    private static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        input = new int[n];
        output = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        dfs(0, 0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int cnt, int idx) {

        if (cnt == m) {

            String s = "";
            for (int e : output) {
                s += String.valueOf(e) + ' ';
            }
            set.add(s);
            return;
        }

        for (int i=idx; i<n; i++) {

            output[cnt] = input[i];
            dfs(cnt+1, i+1);
        }
    }
}