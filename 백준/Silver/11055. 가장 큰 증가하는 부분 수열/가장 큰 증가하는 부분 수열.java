import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new int[N+1];

        String[] input = reader.readLine().split(" ");
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        System.out.println(solution());
    }

    private static int solution() {
        int[] dp = new int[N+1];

        dp[1] = arr[1];
        int max = arr[1];
        for (int i = 1; i <= N; i++) {
            dp[i] = arr[i];

            for (int j = 1; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);

                }
            }

            max = Math.max(max, dp[i]);
        }

        return max;
    }


}