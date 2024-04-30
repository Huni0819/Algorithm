import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {

        Solution solution = new Solution();
        solution.input();
        solution.solution();
    }
}

class Solution {

    private int n;
    private int k;
    private Integer[][] dp;
    private int[] w;
    private int[] v;

    public void input() throws Exception {
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new Integer[n][k+1];
        w = new int[n];
        v = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        reader.close();
    }

    public void solution() {
        System.out.println(knapsack(n-1, k));
    }

    private int knapsack(int i, int k) {
        if (i < 0) {
            return 0;
        }

        if (dp[i][k] == null) {

            if (w[i] > k) {
                dp[i][k] = knapsack(i - 1, k);
            } else if (w[i] <= k) {
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - w[i]) + v[i]);
            }
        }

        return dp[i][k];
    }
}