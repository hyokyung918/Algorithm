import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[8][2];
        
        for (int i=0; i<8; i++) {
            int n = Integer.parseInt(br.readLine());
            arr[i][0] = i;
            arr[i][1] = n;
        }
        
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });
        
        int[] idxArr = new int[5];
        int sum = 0;
        for (int i=0; i<5; i++) {
            sum += arr[i][1];
            idxArr[i] = arr[i][0];
        }
        Arrays.sort(idxArr);
        
        System.out.println(sum);
        for (int i=0; i<5; i++) {
            System.out.printf(idxArr[i]+1 + " ");
        }
    }
}