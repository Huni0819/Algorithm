import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < participant.length; i++) {
            map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
        }
        
        for(String person : completion) {
            int count = map.getOrDefault(person, 0);
            
            if (count == 1 || count == 0) {
                map.remove(person);
            } else {
                map.put(person, count - 1);
            }
        }
        
        Set<String> key = map.keySet();
        Iterator<String> iterator = key.iterator();
        
        String answer = null;
        
        if (iterator.hasNext()) {
            answer = iterator.next();
        }
        
        return answer;
    }
}