import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        if (N == 1 && M == 1) {
            System.out.println(1);
            return;
        }

        arr = new int[N + 1][M + 1];

        int result = 0;
        for (int i = 1; i <= N; i++) {

            input = br.readLine().split("");

            for (int j = 1; j <= M; j++) {

                int num = Integer.parseInt(input[j - 1]);

                if (i == 1 && j == 1) {
                    arr[i][j] = num;
                    continue;
                }

                if (num == 1) {

                    arr[i][j] = Math.min(arr[i - 1][j - 1], Math.min(arr[i - 1][j], arr[i][j - 1])) + 1;
                    result = Math.max(result, arr[i][j]);
                }
            }
        }

        System.out.println(result * result);

    }
}