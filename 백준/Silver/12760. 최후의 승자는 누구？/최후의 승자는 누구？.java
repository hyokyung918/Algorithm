import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr[i]);
        }
        
        int[] max = new int[m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                max[j] = Math.max(max[j], arr[i][j]);
            }
        }
       
        int[] score = new int[n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (max[j] == arr[i][j]) 
                    score[i]++;
            }
        }
        
        int maxScore = 0;
        for (int i=0; i<n; i++) {
            maxScore = Math.max(maxScore, score[i]);
        }
        
        for (int i=0; i<n; i++) {
            if (maxScore == score[i]) {
                System.out.print((i+1) + " ");
            }
        }
    }
}