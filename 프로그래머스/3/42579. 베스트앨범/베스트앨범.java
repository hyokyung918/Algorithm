import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> bestGenre = new HashMap<>();
        HashMap<String, int[]> bestSong = new HashMap<>();
        
        for (int i=0; i<genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            if (bestGenre.containsKey(genre)) {
                bestGenre.put(genre, bestGenre.get(genre)+play);
                
                int[] tmp = bestSong.get(genre);
                if (plays[tmp[0]] < plays[i]) {
                    tmp[1] = tmp[0];
                    tmp[0] = i;
                } else if (tmp[1] == -1 || plays[tmp[1]] < plays[i]) {
                    tmp[1] = i;
                }
                
                bestSong.put(genre, tmp);
            } else {
                bestGenre.put(genre, play);
                int[] tmp = {i, -1};
                bestSong.put(genre, tmp);
            }
        }
        
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(bestGenre.entrySet());
        entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        	return o2.getValue() - o1.getValue();
            }
        });
        
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            String s = entry.getKey();
            int[] tmp = bestSong.get(s);
            answer.add(tmp[0]);
            if (tmp[1] != -1) answer.add(tmp[1]);
        }
        
        int[] output = new int[answer.size()];
        for (int i=0; i<output.length; i++) {
            output[i] = answer.get(i);
        }
        
        return output;
    }
}