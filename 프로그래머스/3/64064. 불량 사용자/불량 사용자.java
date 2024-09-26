import java.util.*;

class Solution {
    public HashSet<HashSet<String>> set = new HashSet<>();
    public String[] user_id, banned_id;
    public boolean[] check;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        check = new boolean[user_id.length];
        bt(0, new HashSet<>());
        return set.size();
    }
    
    public void bt(int count, HashSet<String> list) {
        if (count == banned_id.length) {
            set.add(new HashSet<>(list));
            return;
        }
        
        String banId = banned_id[count];
        for (int i=0; i<user_id.length; i++) {
            if (check[i]) continue;
            String userId = user_id[i];
            
            if (isId(userId, banId)) {
                check[i] = true;
                list.add(userId);
                bt(count+1, list);
                list.remove(userId);
                check[i] = false;
            }
        }
        
    }
    
    public boolean isId(String userId, String banId) {
        if (userId.length() != banId.length()) return false;
        for (int i=0; i<userId.length(); i++) {
            char uChar = userId.charAt(i);
            char bChar = banId.charAt(i);
            if (uChar != bChar && bChar != '*') return false;
        }
        return true;
    }
}