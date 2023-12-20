import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = op(progresses[i], speeds[i]);
            
            int count = 0;
            for (int j = i; j < progresses.length; j++) {
                if (day >= op(progresses[j], speeds[j])) {
                    count++;
                } else {
                    break;
                }
            }
            
            i += count - 1;
            
            result.add(count);
        }
        return result;
    }
    
    public int op(int progress, int speed) {
        int result = (100 - progress) / speed;
        
        if ((100 - progress) % speed != 0) {
            result++;
        }
        
        return result;
    }
}