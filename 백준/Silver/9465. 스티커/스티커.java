import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] arr;
    static int[][][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());

        for (int p = 0; p < t; p++) {
            n = Integer.parseInt(reader.readLine());
            arr = new int[2][n];
            dp = new int[2][n][2];

            for (int i = 0; i < 2; i++) {

                StringTokenizer st = new StringTokenizer(reader.readLine());

                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            System.out.println(solution());
        }

        reader.close();
    }

    private static int solution() {
        // 크게 arr[i][j]가 선택이 되는 경우가 있을거고 선택되지 않는 경우가 존재한다.
        // 3차원 배열을 만들어서 선택이 되는 경우와 선택이 되지 않는 경우를 구해야한다.
        dp[0][0][0] = arr[0][0];
        dp[1][0][0] = arr[1][0];

        for (int i = 1; i < n; i++) {
            // arr[0][i] 를 선택한 경우, 이전 값을 선택한 것과 선택하지 않은 것 중 더 큰값에 arr[0][i]를 더한다.
            dp[0][i][0] = Math.max(dp[1][i-1][0], dp[1][i-1][1]) + arr[0][i];

            // 선택하지 않는 것은 이전의 두 값중에서 큰 값을 가져온다.
            dp[0][i][1] = Math.max(dp[1][i-1][0], dp[0][i-1][0]);

            // arr[0][i] 를 선택한 경우, 이전 값을 선택한 것과 선택하지 않은 것 중 더 큰값에 arr[0][i]를 더한다.
            dp[1][i][0] = Math.max(dp[0][i-1][0], dp[0][i-1][1]) + arr[1][i];

            // 선택하지 않는 것은 이전의 두 값중에서 큰 값을 가져온다.
            dp[1][i][1] = Math.max(dp[1][i-1][0], dp[0][i-1][0]);
        }

        return Math.max(dp[0][n-1][0], dp[1][n-1][0]);
    }
}