import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int M;

    static int[] coins;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(br.readLine());

            coins = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            M = Integer.parseInt(br.readLine());

            sb.append(solution())
                    .append("\n");
        }

        System.out.println(sb);
    }

    static int solution() {

        int[] dp = new int[M + 1]; // M 원을 만드는 경우의 수

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                if (j > coins[i - 1]) { // 동전의 금액이 J 원보다 작을 경우

                    dp[j] += dp[j - coins[i - 1]];
                } else if (j == coins[i - 1]) {

                    dp[j]++;
                }
            }
        }

        return dp[M];
    }
}