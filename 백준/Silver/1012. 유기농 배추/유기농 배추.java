import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Coord> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();
        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {

            String[] input = reader.readLine().split(" ");

            M = Integer.parseInt(input[0]);
            N = Integer.parseInt(input[1]);
            K = Integer.parseInt(input[2]);

            arr = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                input = reader.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);

                arr[x][y] = 1;
            }

            builder.append(solution()).append("\n");
        }

        System.out.println(builder);
    }

    private static int solution() {
        queue = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    visited[i][j] = true;
                    queue.offer(new Coord(i, j));
                    bfs();
                }
            }
        }

        return count;
    }

    private static void bfs() {

        while(!queue.isEmpty()) {

            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 1) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
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