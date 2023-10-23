import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String order = br.readLine();
            int m = Integer.parseInt(br.readLine());
            String s = br.readLine();
            s = s.substring(1, s.length()-1);
            String[] arr = s.split(",");
            boolean isError = false;
            boolean isReversed = false;

            Deque<Integer> deque = new ArrayDeque<Integer>();
            for (int j=0; j<m; j++) {
                deque.add(Integer.parseInt(arr[j].trim()));
            }

            for (int j=0; j<order.length(); j++) {
                char c = order.charAt(j);
                if (c=='R') {
                    if (isReversed) {
                        isReversed = false;
                    } else {
                        isReversed = true;
                    }
                } else {
                    if (deque.isEmpty()) {
                        isError = true;
                        break;
                    } else {
                        if (isReversed) {
                            deque.pollLast();
                        } else {
                            deque.pollFirst();
                        }
                    }
                }
            }

            if (isError) {
                bw.write("error\n");
            } else {
                bw.write("[");
                int t = deque.size();
                if (isReversed) {
                    for (int j=0; j<t; j++) {
                        bw.write(deque.pollLast().toString());
                        if (j<t-1) {
                            bw.write(",");
                        }
                    }
                } else {
                    for (int j=0; j<t; j++) {
                        bw.write(deque.pollFirst().toString());
                        if (j<t-1) {
                            bw.write(",");
                        }
                    }
                }
                bw.write("]\n");
            }
        }
        bw.flush();
        bw.close();
    }
}