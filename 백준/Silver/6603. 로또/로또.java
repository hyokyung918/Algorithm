import java.io.*;
import java.util.*;

class Main {

    private static int k;
    private static int[] arr;
    private static int[] answer = new int[6];
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        while (!s.equals("0")) {

            st = new StringTokenizer(s);
            k = Integer.parseInt(st.nextToken());
            arr = new int[k];
            for (int i=0; i<k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            solve(0, 0);
            sb.append("\n");
            s = br.readLine();
        }

        System.out.println(sb);
    }

    private static void solve(int depth, int index) {

        if (depth == 6) {

            for (int e : answer) {
                sb.append(e).append(' ');
            }
            sb.append("\n");
            return;
        }

        for (int i=index; i<k; i++) {

            answer[depth] = arr[i];
            solve(depth+1, i+1);
        }
    }
}