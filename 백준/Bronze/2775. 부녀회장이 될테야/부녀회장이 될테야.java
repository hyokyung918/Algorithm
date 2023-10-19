import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] apt = new int[k+1][n];
            for (int j=1; j<=n; j++) {
                apt[0][j-1] = j;
            }

            for (int j=1; j<=k; j++) {
                for (int o=0; o<n; o++) {
                    for (int m=0; m<=o; m++) {
                        apt[j][o] += apt[j-1][m];
                    }
                }
            }

            System.out.println(apt[k][n-1]);
        }
    }
}