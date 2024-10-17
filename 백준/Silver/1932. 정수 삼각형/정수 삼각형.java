import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        int[][] arr = new int[N][];

        for (int i = 0; i < N; i++) {
            arr[i] = new int[i+1];


            String[] input = reader.readLine().split(" ");

            for (int j = 0; j < i+1; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(solution(arr));
    }

    static int solution(int[][] arr) {

        int[][] dp = new int[N][];

        dp[N-1] = arr[N-1];

        for (int i = N-2; i >= 0; i--) {
            dp[i] = new int[arr[i].length];

            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.max(dp[i+1][j], dp[i+1][j+1]) + arr[i][j];
            }
        }

        return dp[0][0];
    }
}