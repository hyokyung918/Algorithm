import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i=0; i<n; i++) {

            String s = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int j=0; j<s.length(); j++) {
                char c = s.charAt(j);

                if (stack.empty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.empty()) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}