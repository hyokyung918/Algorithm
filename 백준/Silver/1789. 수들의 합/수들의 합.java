import java.io.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long s = Long.parseLong(br.readLine());

        System.out.println(calc(s, 1));
    }

    private static int calc(long num, long now) {
        if ((num-now) < 0) return 0;
        else if ((num-now) == 0) return 1;
        return 1+calc(num-now, now+1);
    }
}