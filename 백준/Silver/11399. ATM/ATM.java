import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(arr);

        int[] dp = new int[N];
        dp[0] = arr[0];

        int sum = dp[0];
        for (int i = 1; i < N; i++) {
            dp[i] = dp[i - 1] + arr[i];

            sum += dp[i];
        }

        System.out.println(sum);
    }
}