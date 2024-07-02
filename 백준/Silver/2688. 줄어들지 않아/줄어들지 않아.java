import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        long[][] dp = new long[65][10];

        Arrays.fill(dp[0], 1);

        for (int i = 0; i < 65; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < 65; i++) {

            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(reader.readLine());

            long sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += dp[n-1][j];
            }

            System.out.println(sum);
        }
    }
}