import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[k + 1][n + 1];

            for (int i = 1; i <= n; i++) {

                dp[0][i] = i;
            }

            for (int i = 0; i <= k; i++) {

                dp[i][1] = 1;
            }

            if (n >= 2) {

                for (int i = 1; i <= k; i++) {

                    for (int j = 2; j <= n; j++) {

                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
                    }
                }
            }

            System.out.println(dp[k][n]);
        }

    }
}