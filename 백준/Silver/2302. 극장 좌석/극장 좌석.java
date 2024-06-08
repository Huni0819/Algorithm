import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int m;
    static boolean[] arr;
    static int[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        m = Integer.parseInt(reader.readLine());

        arr = new boolean[n+1];
        dp = new int[n+1];

        dp[0] = 1;
        dp[1] = 1;

        if (n >= 2) {
            dp[2] = 2;

            for(int i = 3; i <= n; i++) {
                dp[i] = dp[i-2] + dp[i-1];
            }
        }

        for (int i = 0; i < m; i++) {
            arr[Integer.parseInt(reader.readLine())] = true;
        }

        System.out.println(solution());
    }

    private static int solution() {
        int result = 1;

        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (!arr[i]) {
                count++;
            } else {
                result *= dp[count];
                count = 0;
            }
        }

        return result * dp[count];
    }
}