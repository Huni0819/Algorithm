import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static long[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        arr = new int[n][n];
        dp = new long[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        dp[0][0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == n-1 && j == n-1) {
                    break;
                }

                if (dp[i][j] > 0) {
                    int nx = i + arr[i][j];
                    int ny = j + arr[i][j];

                    if (nx < n) {
                        dp[nx][j] += dp[i][j];
                    }

                    if (ny < n) {
                        dp[i][ny] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}