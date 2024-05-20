import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        String dna = br.readLine();
        
        int[] acgt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] acgtCount = new int[4];
        int answer = 0;
        for (int i=0; i<dna.length()-p+1; i++) {
            
            if (i==0) {
                for (int j=0; j<p; j++) {
                    char c = dna.charAt(j);
                    
                    switch (c) {
                        case 'A':
                            acgtCount[0]++; break;
                        case 'C':
                            acgtCount[1]++; break;
                        case 'G':
                            acgtCount[2]++; break;
                        case 'T':
                            acgtCount[3]++;
                    }
                }
                for (int j=0; j<4; j++) {
                    if (acgt[j] > acgtCount[j]) break;
                    if (j==3) answer++;
                }
                continue;
            }
            
            char c = dna.charAt(i-1);
            switch (c) {
                case 'A':
                    acgtCount[0]--; break;
                case 'C':
                    acgtCount[1]--; break;
                case 'G':
                    acgtCount[2]--; break;
                case 'T':
                    acgtCount[3]--; 
            }
            c = dna.charAt(i+p-1);
            switch (c) {
                case 'A':
                    acgtCount[0]++; break;
                case 'C':
                    acgtCount[1]++; break;
                case 'G':
                    acgtCount[2]++; break;
                case 'T':
                    acgtCount[3]++; 
            }
            
            for (int j=0; j<4; j++) {
                if (acgt[j] > acgtCount[j]) break;
                if (j==3) answer++;
            }
        }
        System.out.println(answer);
    }
}