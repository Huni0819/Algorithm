import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(reader.readLine());

            long[] dp = new long[N+1];
            dp[1] = 1;

            if (N >= 2) {
                dp[2] = 1;
            }

            if (N >= 3) {
                dp[3] = 1;
            }

            for (int i = 4; i <= N; i++) {
                dp[i] = dp[i-2] + dp[i-3];
            }

            System.out.println(dp[N]);
        }

    }
}