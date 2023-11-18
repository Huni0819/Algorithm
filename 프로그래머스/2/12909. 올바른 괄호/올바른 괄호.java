class Solution {
    boolean solution(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (count < 0) {
                return false;
            }
            
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        
        return count == 0;
    }
}