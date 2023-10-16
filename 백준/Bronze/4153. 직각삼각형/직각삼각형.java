import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input ="";

        while (!((input = br.readLine()).equals("0 0 0"))) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            StringTokenizer st = new StringTokenizer(input);

            for (int i=0; i<3; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            Collections.sort(list);

            int a = (int) Math.pow(list.get(0), 2);
            int b = (int) Math.pow(list.get(1), 2);
            int c = (int) Math.pow(list.get(2), 2);

            if (a+b == c)
                System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
