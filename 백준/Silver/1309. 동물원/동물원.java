import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] * 2 + dp[i-2]) % 9901;
        }

        System.out.println(dp[n]);
    }
}