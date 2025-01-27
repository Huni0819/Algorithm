import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            sb.append(solution(N, M))
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int solution(int N, int M) {

        int[][] dp = new int[30][30];

        for (int i = 0; i < 30; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        for (int i = 2; i < 30; i++) {

            for (int j = 1; j < 30; j++) {

                dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
            }
        }

        return dp[M][N];
    }
}