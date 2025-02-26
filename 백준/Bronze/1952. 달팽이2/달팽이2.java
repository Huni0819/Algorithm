import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] d = {

            {0, 1}, {1, 0}, {0, -1}, {-1, 0}
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        System.out.println(solution(M, N));
    }

    static int solution(int M, int N) {

        boolean[][] visited = new boolean[M][N];
        visited[0][0] = true;

        int count = 0;
        int idx = 0;
        int x = 0;
        int y = 0;

        int sum = 1;

        while (idx < 4) {

            int nx = x + d[idx][0];
            int ny = y + d[idx][1];

            if (sum == M * N) {
                break;
            }

            if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visited[nx][ny]) {
                sum++;
                visited[nx][ny] = true;
                x = nx;
                y = ny;
            } else {
                idx++;
                count++;
            }

            if (idx >= 4) {
                idx = 0;
            }
        }

        return count;
    }
}