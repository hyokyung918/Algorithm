import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<int[]> list = new ArrayList<int[]>();
        
        int t = Integer.parseInt(br.readLine());
        int[] a = {1, 0};
        list.add(a);
        int[] b = {0, 1};
        list.add(b);
        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            
            for (int j=list.size(); j<=n; j++) {
                int[] arr = new int[2];
                arr[0] = list.get(j-1)[1];
                arr[1] = list.get(j-1)[0] + list.get(j-1)[1];
                list.add(arr);
            }
            
            int cntZero = list.get(n)[0];
            int cntOne = list.get(n)[1];
            
            System.out.println(cntZero + " " + cntOne);
        }
    }
}