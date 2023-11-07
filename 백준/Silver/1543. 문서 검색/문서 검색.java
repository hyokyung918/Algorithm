import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String text = br.readLine();
        String word = br.readLine();

        int sizeT = text.length();
        int sizeW = word.length();
        
        text = text.replace(word, "");
        
        System.out.println((sizeT-text.length()) / sizeW);
    }
}