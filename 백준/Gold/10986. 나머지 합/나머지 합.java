import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int N;
    static int M;

    static int[] arr;
    static long[] sum;
    static long[] count;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        sum = new long[N + 1];
        count = new long[M];

        long result = 0;

        input = br.readLine().split(" ");
        for (int i = 1; i <= N; i++) {

            sum[i] = (sum[i-1] + Integer.parseInt(input[i - 1])) % M;

            if (sum[i] == 0) {
                result++;
            }

            count[(int) sum[i]]++;
        }

        for (int i = 0; i < M; i++) {

            if (count[i] > 1) {
                result += (count[i] * (count[i] - 1) / 2);
            }
        }

        System.out.println(result);
    }
}