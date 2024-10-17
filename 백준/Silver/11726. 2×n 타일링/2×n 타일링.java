import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] dp = new int[N+1];

        if (N >= 1) {
            dp[1] = 1;
        }

        if (N >= 2) {
            dp[2] = 2;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 10_007;
        }

        System.out.println(dp[N]);
    }
}