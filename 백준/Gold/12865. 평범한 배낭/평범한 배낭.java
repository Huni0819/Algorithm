import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(input[0]); // 물건의 무게
            arr[i][1] = Integer.parseInt(input[1]); // 물건의 가치
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {

                if (arr[i - 1][0] > j) { // 현재 물건을 담을 수 없다면

                    dp[i][j] = dp[i - 1][j];
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j],
                            arr[i - 1][1] + dp[i - 1][j - arr[i - 1][0]]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}