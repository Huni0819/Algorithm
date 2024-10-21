import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        int[] arr = new int[N+1];

        String[] input = reader.readLine().split(" ");

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        int[] dp = new int[N+1];
        dp[1] = 1;

        int max= 1;
        for (int i = 1; i <= N; i++) {
            dp[i] = 1;

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}