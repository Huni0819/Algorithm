import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int M;

    static int[] memories; // 앱 메모리
    static int[] costs; // 앱 시작 비용

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        memories = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        costs = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(solution());
    }

    static int solution() {

        int totalCost = Arrays.stream(costs).sum();
        int[][] dp = new int[N + 1][totalCost + 1]; // i 번째 앱으로 j 비용을 사용해 실행하는 최대 메모리

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= totalCost; j++) {

                if (costs[i - 1] > j) {

                    dp[i][j] = dp[i - 1][j];
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i - 1]] + memories[i - 1]);
                }
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i <= totalCost; i++) {

            if (dp[N][i] >= M) {

                result = Math.min(result, i);
            }
        }

        return result;
    }
}