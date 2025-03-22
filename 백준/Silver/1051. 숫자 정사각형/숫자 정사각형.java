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

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int size = Math.min(N, M);

        loop : while(size > 1) {

            for (int i = 0; i <= N - size; i++) {

                for (int j = 0; j <= M - size; j++) {

                    int num = arr[i][j];

                    if (num == arr[i][j + size - 1] && num == arr[i + size - 1][j] && num == arr[i + size - 1][j + size - 1]) {
                        break loop;
                    }
                }
            }

            size--;
        }

        System.out.println(size * size);
    }
}