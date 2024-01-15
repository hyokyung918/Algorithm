import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int t=0; t<tc; t++) {

            HashSet<Integer>[] setArr = new HashSet[3];
            HashSet<Integer> luckyCount = new HashSet<>();

            for (int i=0; i<3; i++) {

                setArr[i] = new HashSet<>();
                int n = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());

                for (int j=0; j<n; j++) {
                    int tmp = Integer.parseInt(st.nextToken());
                    setArr[i].add(tmp);
                }
            }

            for (int a : setArr[0]) {
                for (int b : setArr[1]) {
                    for (int c : setArr[2]) {

                        int calc = a+b+c;
                        String s = Integer.toString(calc);

                        for (int i=0; i<s.length(); i++) {
                            char ch = s.charAt(i);

                            if (ch!='5' && ch!='8') {
                                break;
                            }
                            if (i==s.length()-1) {
                                luckyCount.add(calc);
                            }
                        }
                    }
                }
            }

            System.out.println(luckyCount.size());
        }
    }
}