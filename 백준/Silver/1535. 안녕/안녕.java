import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int[] L;
    static int[] J;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        L = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        J = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] dp = new int[N + 1][101];

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= 100; j++) {

                if (j <= L[i - 1]) { // 체력이 부족해서 인사를 못하는 경우

                    dp[i][j] = dp[i - 1][j];
                } else {    //  인사를 할 수 있는 경우

                    dp[i][j] = Math.max(dp[i - 1][j],
                            J[i - 1] + dp[i - 1][j - L[i - 1]]);
                }
            }
        }

        System.out.println(dp[N][100]);
    }
}