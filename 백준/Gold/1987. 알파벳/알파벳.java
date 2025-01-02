import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int R;
    static int C;

    static int max = 0;

    static char[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = new char[R][];

        for (int i = 0; i < R; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        visited = new boolean['Z' - 'A' + 1];

        solution(0, 0, 1);
        System.out.println(max);
    }

    static void solution(int x, int y, int count) {

        visited[arr[x][y] - 'A'] = true;
        max = Math.max(max, count);

        for (int i = 0; i < d.length; i++) {

            int nx = x + d[i][0];
            int ny = y + d[i][1];

            if (!checkBound(nx, ny) || visited[arr[nx][ny] - 'A']) {
                continue;
            }

            solution(nx, ny, count + 1);
            visited[arr[nx][ny] - 'A'] = false;
        }
    }

    static boolean checkBound(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}