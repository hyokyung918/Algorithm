import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            String[] arr = s.split(" ");

            for (int j=0; j<arr.length; j++) {
                for (int k=arr[j].length()-1; k>-1; k--) {
                    bw.write(arr[j].charAt(k));
                }
                bw.write(" ");
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}