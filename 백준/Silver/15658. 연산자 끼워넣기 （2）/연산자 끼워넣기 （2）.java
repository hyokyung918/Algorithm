import java.io.*;
import java.util.*;

class Main {

    private static int n;
    private static int[] numList, operList;
    private static char[] operSelect;
    private static Set<String> operatorSet = new HashSet<>();
    private static int MIN = Integer.MAX_VALUE;
    private static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numList = new int[n];
        operSelect = new char[n-1];
        operList = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operList[i] = Integer.parseInt(st.nextToken());
        }

        search(0);
        calc();
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void search(int cnt) {

        if (cnt == n-1) {

            String s = "";
            for (char c : operSelect) {
                s += c;
            }
            operatorSet.add(s);
            return;
        }

        for (int i=0; i<4; i++) {
            
            if (operList[i] == 0) continue;
            
            char operator;
            
            switch (i) {
                case 0:
                    operator = '+';
                    break;
                case 1:
                    operator = '-';
                    break;
                case 2:
                    operator = '*';
                    break;
                default:
                    operator = '/';
            }

            operSelect[cnt] = operator;
            operList[i]--;
            search(cnt+1);
            operList[i]++;
        }
    }

    private static void calc() {

        for (String s : operatorSet) {
            int answer = numList[0];

            for (int i=0; i<n-1; i++) {

                char x = s.charAt(i);

                switch (x) {
                    case '+':
                        answer += numList[i+1];
                        break;
                    case '-':
                        answer -= numList[i+1];
                        break;
                    case '*':
                        answer *= numList[i+1];
                        break;
                    case '/':
                        if (answer > 0) {
                            answer *= -1;
                            answer /= numList[i+1];
                            answer *= -1;
                        } else {
                            answer /= numList[i+1];
                        }
                }
            }

            if (answer > MAX) MAX = answer;
            if (answer < MIN) MIN = answer;
        }
    }
}