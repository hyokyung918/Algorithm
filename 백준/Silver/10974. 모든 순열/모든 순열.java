import java.io.*;

public class Main {

    private static int n;
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        visited = new boolean[n];

        dfs(0);
    }

    private static void dfs(int num) {

        if (num == n) {
            for (int i=0; i<n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                arr[num] = i+1;
                visited[i] = true;
                dfs(num+1);
                visited[i] = false;
            }
        }
    }
}