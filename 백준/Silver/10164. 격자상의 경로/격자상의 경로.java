import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int k;

    static Integer[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 무조건 지나가야 하는 칸

        int kx = k / m + 1;
        int ky = k - m * (kx - 1);

        if (ky == 0) {
            kx--;
            ky = m;
        }

        dp = new Integer[n+1][m+1];

        for (int i = 1; i <= m; i++) {
            dp[1][i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][1] = 1;
        }

        if (n > 1 && m > 1) {
            for (int i = 2; i <= n; i++) {
                for (int j = 2; j <= m; j++) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        if (k == 0) {
            System.out.println(dp[n][m]);
        } else {
            System.out.println(dp[kx][ky] * dp[n-kx+1][m-ky+1]);
        }
    }

}