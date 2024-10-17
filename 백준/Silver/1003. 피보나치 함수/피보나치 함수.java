import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {

            int N = Integer.parseInt(reader.readLine());

            int[][] dp = new int[N+1][2];
            dp[0][0] = 1;

            if (N >= 1) {
                dp[1][1] = 1;
            }

            for (int i = 2; i <= N; i++) {

                dp[i][0] = dp[i-1][0] + dp[i-2][0];
                dp[i][1] = dp[i-1][1] + dp[i-2][1];
            }

            builder.append(dp[N][0])
                    .append(" ")
                    .append(dp[N][1])
                    .append("\n");
        }

        System.out.print(builder);
    }
}