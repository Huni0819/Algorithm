import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(reader.readLine());

            int[] dp = new int[N+1];
            dp[0] = 1;

            if (N >= 1) {
                dp[1] = 1;
            }

            if (N >= 2) {
                dp[2] = 2;
            }

            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
            }

            builder.append(dp[N])
                    .append("\n");
        }

        System.out.println(builder);
    }
}