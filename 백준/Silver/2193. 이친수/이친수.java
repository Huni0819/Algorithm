import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        long[] dp = new long[N+1];
        dp[1] = 1L;

        for (int i = 2; i <= N; i++) {

            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}