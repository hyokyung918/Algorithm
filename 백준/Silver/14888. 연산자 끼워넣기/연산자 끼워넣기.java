import java.io.*;
import java.util.*;

class Main {

    private static int n;
    private static int[] numArr;
    private static int[] operArr = new int[4];
    private static Set<String> selectSet = new HashSet<>();
    private static int[] selectArr;

    private static int MAX = Integer.MIN_VALUE;
    private static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        numArr = new int[n];
        selectArr = new int[n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<4; i++) {
            operArr[i] = Integer.parseInt(st.nextToken());
        }

        bt(0);
        calculate();
        System.out.println(MAX);
        System.out.println(MIN);
    }

    private static void bt(int depth) {

        if (depth == n-1) {
            String s="";
            for (int i=0; i<n-1; i++) {
                s += selectArr[i];
            }
            selectSet.add(s);
            return;
        }

        for (int i=0; i<4; i++) {

            if (operArr[i] == 0) continue;

            selectArr[depth] = i;
            operArr[i]--;
            bt(depth+1);
            operArr[i]++;
        }
    }

    private static void calculate() {

        for (String s : selectSet) {
            int calc = numArr[0];

            for (int i=0; i<n-1; i++) {
                switch (s.charAt(i)) {
                    case '0':
                        calc += numArr[i+1];
                        break;
                    case '1':
                        calc -= numArr[i+1];
                        break;
                    case '2':
                        calc *= numArr[i+1];
                        break;
                    default:
                        calc /= numArr[i+1];
                }
            }

            MAX = Math.max(MAX, calc);
            MIN = Math.min(MIN, calc);
        }
    }
}