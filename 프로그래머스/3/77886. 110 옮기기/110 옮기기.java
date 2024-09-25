import java.util.*;

class Solution {
    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for (int i=0; i<s.length; i++) {
            String str = s[i];
            int count = 0;
            Stack<Character> stack = new Stack<>();
            
            for (int j=0; j<str.length(); j++) {
                stack.push(str.charAt(j));
                
                if (stack.size() >= 3) {
                    if (stack.get(stack.size()-1) == '0' && stack.get(stack.size()-2) == '1' && stack.get(stack.size()-3) == '1') {
                        stack.pop(); stack.pop(); stack.pop();
                        count++;
                    }
                }
            }
            
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                char c = stack.pop();
                sb.insert(0, c);
            }
            
            while (count>0) {
                int idx = sb.lastIndexOf("0");
                sb.insert(idx+1, "110");
                count--;
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}