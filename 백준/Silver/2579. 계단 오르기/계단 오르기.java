import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main {

    static int N;
    static int[] arr;
    static Integer[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new int[N+1];
        dp = new Integer[N+1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        dp[0] = 0;

        if (N >= 1) {
            dp[1] = arr[1];
        }

        if (N >= 2) {
            dp[2] = arr[2] + arr[1];
        }

        int result = solution(N);

        System.out.println(result);
    }

    static int solution(int N) {

        if(Objects.isNull(dp[N])) {

            dp[N] = Math.max(solution(N-3) + arr[N-1], solution(N-2)) + arr[N];
        }

        return dp[N];
    }
}