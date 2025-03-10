import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[][] arr;

    static int result = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String[] input =  br.readLine().split(" ");

            for (int j = 1; j <= N; j++) {

                arr[i][j] = Integer.parseInt(input[j - 1]);
            }
        }

        solution(1, 2, 0);
        System.out.println(result);
    }

    static void solution(int x, int y, int di) {

        if (x == N && y == N) {

            result++;
            return;
        }

        if (di == 0) {

            if (y + 1 <= N && arr[x][y + 1] == 0) {
                solution(x, y + 1, 0);
            }

        } else if (di == 1) {

            if (x + 1 <= N && arr[x + 1][y] == 0) {
                solution(x + 1, y, 1);
            }
        } else {

            if (y + 1 <= N && arr[x][y + 1] == 0) {
                solution(x, y + 1, 0);
            }

            if (x + 1 <= N && arr[x + 1][y] == 0) {
                solution(x + 1, y, 1);
            }
        }

        if (x + 1 <= N && y + 1 <= N && arr[x + 1][y + 1] == 0 && arr[x][y + 1] == 0 && arr[x + 1][y] == 0) {
            solution(x + 1, y + 1, 2);
        }
    }
}