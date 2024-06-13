import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] visited;

    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                general(i, j, 1, arr[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(max);
    }


    private static void general(int x, int y, int depth, int sum) {

        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int k = 0; k < 4; k++) {

            int nx = x + dx[k];
            int ny = y + dy[k];

            if (nx >= n || ny >= m || nx < 0 || ny < 0) {
                continue;
            }

            if (!visited[nx][ny]) {

                if (depth == 2) {
                    visited[nx][ny] = true;
                    general(x, y, depth + 1, sum + arr[nx][ny]);
                    visited[nx][ny] = false;
                }

                visited[nx][ny] = true;
                general(nx, ny, depth + 1, sum + arr[nx][ny]);
                visited[nx][ny] = false;
            }
        }
    }
}