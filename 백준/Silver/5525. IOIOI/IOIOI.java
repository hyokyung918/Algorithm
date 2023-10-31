import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int ans = 0;
        int cnt = 0;
        char c = 'O';
        for (int i=0; i<m; i++) {
            char tmpChar = s.charAt(i);
            
            if (c == tmpChar) {
                if (tmpChar == 'O') {
                    cnt = 0;
                } else {
                    cnt = 1;
                }
            } else {
                cnt++;
            }
            c = tmpChar;
            
            if (c == 'I' && cnt >= 2*n+1) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}