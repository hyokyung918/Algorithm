import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Map<Character, Integer> map = new HashMap<Character, Integer>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        inputValues(n);
        System.out.printf("%.2f", calculate(s));
    }

    private static void inputValues(int n) throws IOException {
        for (int i=0; i<n; i++) {
            int val = Integer.parseInt(br.readLine());
            map.put((char)(65+i), val);
        }
    }

    private static double calculate(String s) {
        Stack<Double> stack = new Stack<>();

        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            double a;
            double b;

            switch (c) {
                case '*':
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(a * b);
                    break;

                case '/':
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b / a);
                    break;

                case '+':
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(a + b);
                    break;

                case '-':
                    a = stack.pop();
                    b = stack.pop();
                    stack.add(b - a);
                    break;

                default:
                    stack.add(Double.valueOf(map.get(c)));
            }
        }

        return stack.pop();
    }
}