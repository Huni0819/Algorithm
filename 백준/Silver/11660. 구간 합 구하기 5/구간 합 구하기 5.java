import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {

            input = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {

                arr[i][j] = arr[i - 1][j] + arr[i][j - 1] - arr[i - 1][j - 1] + Integer.parseInt(input[j - 1]);
            }
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            sb.append(arr[x2][y2] - arr[x2][y1 - 1] - arr[x1 - 1][y2] + arr[x1 - 1][y1 - 1])
                    .append("\n");
        }

        System.out.println(sb);
    }
}