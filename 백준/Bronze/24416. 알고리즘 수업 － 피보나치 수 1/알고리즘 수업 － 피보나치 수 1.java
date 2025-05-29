import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int dfsCount = 0;
    static int dpCount = 0;
    static int[] dp = new int[41];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;

        dfs(n);
        dp(n);

        System.out.println(++dfsCount + " " + dpCount);
    }

    static int dfs(int n) {

        if (n == 1 || n == 2) {
            return 1;
        }

        dfsCount++;
        return dfs(n - 1) + dfs(n - 2);
    }

    static int dp(int n) {

        if (dp[n] == 0) {

            dpCount++;

            dp[n] = dp(n - 1) + dp[n - 2];
        }

        return dp[n];
    }
}