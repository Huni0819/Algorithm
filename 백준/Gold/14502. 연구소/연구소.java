import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] visited;

    static int max = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 벽 3개를 세워야 한다.
        // 0 3개를 1로 바꿔야함.

        solution(0);

        System.out.println(max);
    }

    private static void solution(int depth) {

        if (depth == 3) {
            max = Math.max(max, checkArr());
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1;
                    solution(depth + 1);
                    arr[i][j] = 0;
                }
            }
        }
    }

    private static int checkArr() {
        visited = new boolean[n][m];

        Queue<Coord> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) {
                    queue.offer(new Coord(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && arr[nx][ny] == 0) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                } else if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && arr[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}

class Coord {

    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}