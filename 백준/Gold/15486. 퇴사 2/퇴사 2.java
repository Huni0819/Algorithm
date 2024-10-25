import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");

            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }

        int[] dp = new int[N+1];

        for (int i = 0; i < N; i++) {
            if (i + arr[i][0] <= N) {
                dp[i + arr[i][0]] = Math.max(dp[i + arr[i][0]], dp[i] + arr[i][1]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[N]);

    }
}