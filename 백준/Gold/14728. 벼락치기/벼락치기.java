import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int T;

    static int[] K; // 예상 공부 시간
    static int[] S; // 배점


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        T = Integer.parseInt(input[1]);

        K = new int[N];
        S = new int[N];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");
            K[i] = Integer.parseInt(input[0]);
            S[i] = Integer.parseInt(input[1]);
        }

        System.out.println(solution());
    }

    static int solution() {

        int[][] dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= T; j++) {

                if (j < K[i - 1]) { // i 단원을 학습하지 못하는 경우

                    dp[i][j] = dp[i - 1][j];
                } else { // i 단원을 학습할 수 있는 경우

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - K[i - 1]] + S[i - 1]);
                }
            }
        }

        return dp[N][T];
    }
}