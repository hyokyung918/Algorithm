import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, HashSet<String>> map1 = new HashMap<>();
        HashMap<String, HashSet<String>> map2 = new HashMap<>();
        
        for (int i=0; i<report.length; i++) {
            String[] id = report[i].split(" ");
            HashSet<String> tmpSet = new HashSet<>();
            
            if (map1.containsKey(id[1])) {
                tmpSet = map1.get(id[1]);
                tmpSet.add(id[0]);
                map1.put(id[1], tmpSet);
            } else {
                tmpSet.add(id[0]);
                map1.put(id[1], tmpSet);
            }
            
            tmpSet = new HashSet<>();
            if (map2.containsKey(id[0])) {
                tmpSet = map2.get(id[0]);
                tmpSet.add(id[1]);
                map2.put(id[0], tmpSet);
            } else {
                tmpSet.add(id[1]);
                map2.put(id[0], tmpSet);
            }
        }
        
        HashSet<String> stopSet = new HashSet<>();
        for (String s : map1.keySet()) {
            if (map1.get(s).size() >= k) stopSet.add(s);
        }
        
        int[] answer = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            String userId = id_list[i];
            HashSet<String> tmpSet = map2.get(userId);
            if (tmpSet == null) continue;
            for (String s : stopSet) {
                if (tmpSet.contains(s)) answer[i]++;
            }
        }
        return answer;
    }
}