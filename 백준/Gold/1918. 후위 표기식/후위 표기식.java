import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            switch (c) {
                case '+': case '-': case '*': case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        sb.append(stack.pop());
                    }
                    stack.add(c);
                    break;

                case '(':
                    stack.add(c);
                    break;

                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;

                default:
                    sb.append(c);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }

    private static int priority(char c) {
        switch (c) {
            case '(': case ')':
                return 0;
            case '+': case '-':
                return 1;
            case '*': case '/':
                return 2;
            default:
                return -1;
        }
    }
}