import java.io.*;
import java.util.*;

class Main {

    private static int n, m;
    private static int[] arr, answer;
    private static boolean[] visit;
    private static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        answer = new int[m];
        visit = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        for (String s : set) {
            System.out.println(s);
        }
    }

    private static void dfs(int cnt) {

        if (cnt == m) {

            String s = "";
            for (int e : answer) {
                s += e + " ";
            }
            set.add(s);
            return;
        }

        for (int i=0; i<n; i++) {

            if (visit[i]) {
                continue;
            }

            answer[cnt] = arr[i];
            visit[i] = true;
            dfs(cnt+1);
            visit[i] = false;
        }
    }
}