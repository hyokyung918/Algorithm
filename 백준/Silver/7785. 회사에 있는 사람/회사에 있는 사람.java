import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();
        
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            String s = br.readLine();
            String[] tmp = s.split(" ");
            
            if (tmp[1].equals("enter")) {
                map.put(tmp[0], tmp[1]);
            } else {
                map.remove(tmp[0]);
            }
        }
        
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        for (String e : list) {
            System.out.println(e);
        }
    }
}