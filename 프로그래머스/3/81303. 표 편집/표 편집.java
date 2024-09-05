import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st;
        int size = n;
        
        for (String str : cmd) {
            st = new StringTokenizer(str);
            char c = st.nextToken().charAt(0);
            
            switch (c) {
                case 'U':
                    k -= Integer.parseInt(st.nextToken()); break;
                case 'D':
                    k += Integer.parseInt(st.nextToken()); break;
                case 'C':
                    stack.push(k);
                    size--;
                    if (k == size) k--;
                    break;
                default:
                    if (stack.pop() <= k) k++;
                    size++;
            }
            if (k<0) k=0;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<size; i++) sb.append("O");
        while (!stack.isEmpty()) {
            sb.insert(stack.pop(), "X");
        }
        return sb.toString();
    }
}