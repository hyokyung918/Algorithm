import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        boolean isTag = false;
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '<') {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
                isTag = true;
            } else if (str.charAt(i) == '>') {
                isTag = false;
                sb.append(str.charAt(i));
                continue;
            }

            if (isTag) {
                sb.append(str.charAt(i));
            } else {
                if (str.charAt(i) == ' ') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                } else {
                    stack.push(str.charAt(i));
                }
            }

            if (i == str.length()-1) {
                while (!stack.empty()) {
                    sb.append(stack.pop());
                }
            }
        }
        System.out.println(sb);
    }
}