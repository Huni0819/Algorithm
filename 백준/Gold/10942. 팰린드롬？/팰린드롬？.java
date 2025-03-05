import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;
    static int[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        dp = new int[N + 1][N + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {

            arr[i] = Integer.parseInt(input[i - 1]);
        }

        solution();

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");

            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            sb.append(dp[start][end])
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void solution() {

        for (int i = 1; i <= N; i++) {

            dp[i][i] = 1;
        }

        for (int i = 1; i < N; i++) {

            if (arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for (int i = 2; i < N; i++) {

            for (int j = 1; j <= N - i; j++) {

                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1) {
                    dp[j][j + i] = 1;
                }
            }
        }
    }
}