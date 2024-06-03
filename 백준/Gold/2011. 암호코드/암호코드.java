import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String pwd = reader.readLine();
        long[] dp = new long[pwd.length()+1];
        dp[0] = 1;
        dp[1] = 1;

        if (pwd.charAt(0) == '0') {
            System.out.println(0);
            System.exit(0);
        }

        for (int i = 2; i <= pwd.length(); i++) {
            // 해당 숫자가 1~9 사이의 수라면
            // dp[i-1] +
            // 해당 숫자와 앞 숫자가 2자리로 알파벳이 완성이 된다면
            // dp[i-2] +

            int now = pwd.charAt(i-1) - '0';

            if (now > 0 && now < 10) {
                dp[i] += dp[i-1];
            }

            int value = (pwd.charAt(i-2) - '0') * 10 + now;

            if (value >= 10 && value <= 26) {
                dp[i] += dp[i-2];
            }

            dp[i] %= 1_000_000;
        }

        System.out.println(dp[pwd.length()]);
    }
}