import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static Integer[] dp;
    static String[] calc;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());

        dp = new Integer[n+1];
        calc = new String[n+1];
        dp[0] = 0;
        dp[1] = 0;
        calc[1] = "1";

        System.out.println(solution(n));
        System.out.println(calc[n]);
    }

    private static Integer solution(int n) {

        if (dp[n] != null) {
            return dp[n];
        }

        int x1 = Integer.MAX_VALUE;
        int x2 = Integer.MAX_VALUE;
        int x3 = Integer.MAX_VALUE;

        if (n % 3 == 0) {
            x3 = solution(n/3);
        }

        if (n % 2 == 0) {
            x2 = solution(n/2);
        }

        x1 = solution(n-1);

        if (x1 <= x2 && x1 <= x3) {
            calc[n] = n + " " + calc[n-1];
        } else if (x2 <= x1 && x2 <= x3) {
            calc[n] = n + " " + calc[n/2];
        } else {
            calc[n] = n + " " + calc[n/3];
        }

        return dp[n] = Math.min(x1, Math.min(x2, x3)) + 1;
    }
}