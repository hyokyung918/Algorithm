import java.io.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arr1, int[] arr2) {
                int y1 = arr1[1];
                int y2 = arr2[1];
                if (y1 != y2)
                    return y1 - y2;

                int x1 = arr1[0];
                int x2 = arr2[0];
                return x1 - x2;
            }
        });

        for (int i=0; i<n; i++) {
            bw.write(String.valueOf(arr[i][0]) + " " + String.valueOf(arr[i][1]) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
