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

    static char[][] arr;
    static int[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        visited = new int[N][M][2];

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
        queue.offer(new Coord(0, 0, 0));
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            if (now.x == N-1 && now.y == M-1) {
                return visited[now.x][now.y][now.wall];
            }

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][now.wall] != 0) {
                    continue;
                }

                if (arr[nx][ny] == '0') {
                    visited[nx][ny][now.wall] = visited[now.x][now.y][now.wall] + 1;
                    queue.offer(new Coord(nx, ny, now.wall));
                } else if (arr[nx][ny] == '1' && now.wall == 0) {
                    visited[nx][ny][1] = visited[now.x][now.y][now.wall] + 1;
                    queue.offer(new Coord(nx, ny, 1));
                }
            }
        }

        return -1;
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