import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    //      dp[1] = 1
//        1
//      dp[2] = 1
//        10
//      dp[3] = 2
//        100, 101
//      dp[4] = 3
//        1_000, 1_001, 1_010
//      dp[5] = 5
//        10_000, 10_001, 10_010, 10_100, 10_101
//      dp[6] = 8
//        100_000, 100_001, 100_010, 100_100, 101_000, 100_101, 101_001, 101_010
//      dp[7] = 13
//        1_000_000, 1_000_001, 1_000_010, 1_000_100, 1_001_000, 1_010_000, 1_000_101, 1_001_001
//        1_001_010, 1_010_001, 1_010_010, 1_010_100, 1_010_101
    private static long solution(int n) {
        if (n <= 2) {
            return 1;
        }

        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    static long[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        dp = new long[n+1];

        System.out.println(solution(n));

        reader.readLine();
    }
}