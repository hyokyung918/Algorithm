import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int country = Integer.parseInt(st.nextToken());
            int stdNum = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            arr[i][0] = country;
            arr[i][1] = stdNum;
            arr[i][2] = score;
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[]o2) {
                return o2[2] - o1[2];
            }
        });
        
        int[][] list = new int[3][2];
        list[0][0] = arr[0][0];
        list[0][1] = arr[0][1];
        list[1][0] = arr[1][0];
        list[1][1] = arr[1][1];
        
        for (int i=2; i<arr.length; i++) {
            if (arr[i][0] == list[0][0] && arr[i][0] == list[1][0]) {
                continue;
            }
            list[2][0] = arr[i][0];
            list[2][1] = arr[i][1];
            break;
        }
        
        for (int i=0; i<3; i++) {
            System.out.println(list[i][0] + " " + list[i][1]);
        }
    }
}