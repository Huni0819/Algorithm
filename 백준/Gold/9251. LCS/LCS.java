import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    
    static char[] word1;
    static char[] word2;
    
    static Integer[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        word1 = br.readLine().toCharArray();
        word2 = br.readLine().toCharArray();
        
        dp = new Integer[word1.length][word2.length];

        System.out.println(solution(word1.length - 1, word2.length - 1));
    }
    
    static int solution(int x, int y) {
        
        if (x == -1 || y == -1) {
            
            return 0;
        }
        
        if (dp[x][y] == null) {
            
            
            dp[x][y] = 0;
            
            if (word1[x] == word2[y]) {
                dp[x][y] = solution(x - 1, y - 1) + 1;
            } else {
                
                dp[x][y] = Math.max(solution(x - 1, y), solution(x, y - 1));
            }
        }
        
        return dp[x][y];
    }
}