import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        long[] dp = new long[1_101];

        String[] input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {

            arr[i] = Integer.parseInt(input[i - 1]);
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 0;

        for (int i = 1; i <= N; i++) {

            if (dp[i] >= Integer.MAX_VALUE) {
                continue;
            }

            for (int j = 1; j <= arr[i]; j++) {

                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }

        if (dp[N] >= Integer.MAX_VALUE) {

            System.out.print(-1);
        } else {

            System.out.print(dp[N]);
        }
    }
}