import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int N;
    static int M;
    static int K;

    static char[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {

            String line = reader.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        Queue<Coord> queue = new LinkedList<>();
        int[][][] visited = new int[N][M][K+1];

        queue.offer(new Coord(0, 0, K));
        visited[0][0][K] = 1;

        while (!queue.isEmpty()) {

            Coord now = queue.poll();

            if (now.x == N-1 && now.y == M-1) {
                return visited[now.x][now.y][now.wall];
            }

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (!checkOutOfBound(nx, ny)) {
                    continue;
                }

                if (arr[nx][ny] == '0' && visited[nx][ny][now.wall] == 0) {
                    queue.offer(new Coord(nx, ny, now.wall));
                    visited[nx][ny][now.wall] = visited[now.x][now.y][now.wall] + 1;
                }

                if (now.wall > 0 && arr[nx][ny] == '1' && visited[nx][ny][now.wall - 1] == 0) {
                    queue.offer(new Coord(nx, ny, now.wall - 1));
                    visited[nx][ny][now.wall - 1] = visited[now.x][now.y][now.wall] + 1;
                }
            }
        }

        return -1;
    }

    static boolean checkOutOfBound(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < M);
    }
}

class Coord {

    int x;
    int y;
    int wall;

    public Coord(int x, int y, int wall) {
        this.x = x;
        this.y = y;
        this.wall = wall;
    }
}