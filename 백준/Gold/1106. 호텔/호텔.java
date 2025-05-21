import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int C;
    static int N;
    static int maxCustomerPerCity = 0;

    static int[][] cities;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        C = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        cities = new int[N][2];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");
            cities[i][0] = Integer.parseInt(input[0]);
            cities[i][1] = Integer.parseInt(input[1]);

            maxCustomerPerCity = Math.max(maxCustomerPerCity, cities[i][1]);
        }

        System.out.println(solution());
    }

    static int solution() {

        int[] dp = new int[C + maxCustomerPerCity + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i <= C + maxCustomerPerCity; i++) {

            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }

            for (int[] city : cities) {

                if (i + city[1] > C + maxCustomerPerCity) {
                    continue;
                }

                dp[i + city[1]] = Math.min(dp[i + city[1]], dp[i] + city[0]);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i = C; i <= C + maxCustomerPerCity; i++) {

            minCost = Math.min(minCost, dp[i]);
        }

        return minCost;
    }
}