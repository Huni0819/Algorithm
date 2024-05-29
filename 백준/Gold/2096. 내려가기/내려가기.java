import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][3];
        int[][][] dp = new int[n][3][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0][i], arr[0][i]);
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j + 1][0]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i - 1][j + 1][1]) + arr[i][j];
                } else if (j == 2) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j - 1][0]) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], dp[i - 1][j - 1][1]) + arr[i][j];
                } else {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], Math.max(dp[i - 1][j - 1][0], dp[i - 1][j + 1][0])) + arr[i][j];
                    dp[i][j][1] = Math.min(dp[i - 1][j][1], Math.min(dp[i - 1][j - 1][1], dp[i - 1][j + 1][1])) + arr[i][j];
                }
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            max = Math.max(dp[n - 1][i][0], max);
            min = Math.min(dp[n - 1][i][1], min);
        }

        System.out.println(max + " " + min);
    }
}