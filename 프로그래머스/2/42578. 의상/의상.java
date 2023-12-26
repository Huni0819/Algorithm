import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        add(clothes, map);
        
        int count = 1;

        for (int value : map.values()) {
            count *= value;
        }

        return count - 1;
    }

    private void add(String[][] clothes, Map<String, Integer> map) {
        for (String[] cloth : clothes) {
            int size = map.getOrDefault(cloth[1], 1);

            map.put(cloth[1], size + 1);
        }
    }
}