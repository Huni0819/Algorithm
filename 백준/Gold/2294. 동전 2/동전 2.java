import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int k;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k+1];
        Arrays.fill(dp, 100_001);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        int result = solution();

        System.out.println(result == 100_001 ? -1 : result);

        reader.close();
    }

    private static int solution() {

        for (int i = 0; i < n; i++) {

            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j-arr[i]]);

//                dp[j] = Math.min(dp[j], (j / arr[i]) + dp[j % arr[i]]);
            }
        }

        return dp[k];
    }
}