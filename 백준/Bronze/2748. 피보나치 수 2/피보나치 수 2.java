import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static Long[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());
        dp = new Long[N+1];
        dp[0] = 0L;
        dp[1] = 1L;

        if (N >= 2) {
            dp[2] = 1L;
        }

        System.out.println(solution(N));
    }

    public static long solution(int N) {

        if (N <= 2) {
            return dp[N];
        }

        if (dp[N] == null) {

            dp[N] = solution(N-1) + solution(N-2);
        }

        return dp[N];
    }
}