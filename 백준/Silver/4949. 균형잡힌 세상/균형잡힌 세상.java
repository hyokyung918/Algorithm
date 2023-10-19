import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        input = br.readLine();
        while (!input.equals(".")) {
            Stack<Character> stack = new Stack<>();

            boolean isBalance = true;
            for (int i=0; i<input.length(); i++) {
                char c = input.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (stack.empty() || stack.peek() != '(') {
                        isBalance = false;
                        break;
                    } else {
                        stack.pop();
                    }
                } else if (c == ']') {
                    if (stack.empty() || stack.peek() != '[') {
                        isBalance = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.empty()) {
                isBalance = false;
            }
            
            if (isBalance) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

            input = br.readLine();
        }
    }
}