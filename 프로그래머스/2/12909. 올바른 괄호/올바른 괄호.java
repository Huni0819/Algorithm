class Solution {
    boolean solution(String s) {
        int count = counting(s);
        
        return count == 0;
    }
    
    int counting(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (count < 0) {
                return count;
            }
            
            if (s.charAt(i) == '(') {
                count++;
            } else {
                count--;
            }
        }
        
        return count;
    }
}