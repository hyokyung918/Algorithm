import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        HashMap<Integer, Character> map = new HashMap<>();
        for (int i=0; i<strings.length; i++) {
            map.put(i, strings[i].charAt(n));
        }
        
        List<Map.Entry<Integer, Character>> entrySet = new ArrayList<>(map.entrySet());
        Collections.sort(entrySet, new Comparator<Map.Entry<Integer, Character>>() {
            @Override
            public int compare(Map.Entry<Integer, Character> e1, Map.Entry<Integer, Character> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        });
        
        ArrayList<String> answer = new ArrayList<>();
        for (int i=0; i<entrySet.size(); i++) {
            Map.Entry<Integer, Character> entry = entrySet.get(i);
            ArrayList<String> list = new ArrayList<>();
            list.add(strings[entry.getKey()]);
            
            int j=i+1;
            for (; j<entrySet.size(); j++) {
                Map.Entry<Integer, Character> tmpEntry = entrySet.get(j);
                if (tmpEntry.getValue() != entry.getValue()) break;
                list.add(strings[tmpEntry.getKey()]); 
            }
            i=j-1;
            
            Collections.sort(list);
            for (String s : list) {
                answer.add(s);
            }
        }
        
        return answer.toArray(new String[answer.size()]);
    }
}