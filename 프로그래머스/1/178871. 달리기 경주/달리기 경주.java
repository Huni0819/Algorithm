import java.util.HashMap;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> player = new HashMap<>();
        HashMap<Integer, String> rank = new HashMap<>();
        
        for (int i = 0; i < players.length; i++) {
            player.put(players[i], i);
            rank.put(i, players[i]);
        }
        
        for (String call : callings) {
            int r = player.get(call);
            
            String p1 = rank.get(r);
            String p2 = rank.get(r-1);
            
            rank.put(r, p2);
            rank.put(r-1, p1);
            
            player.put(p1, r-1);
            player.put(p2, r);
        }
        
        String[] answer = new String[players.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = rank.get(i);
        }
        
        return answer;
    }
}