import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {

            String[] input = reader.readLine().split(" ");

            for (int j = 0; j < N; j++) {

                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] == 0) {
                    continue;
                }

                int count = 0;

                for (int k = 0; k < d.length; k++) {

                    int nx = i + d[k][0];
                    int ny = j + d[k][1];

                    if (!checkOutOfBound(nx, ny) && arr[nx][ny] == 0) {
                        count++;
                    }
                }

                if (count > 0) {
                    min = Math.min(min, solution(i, j));
                }
            }
        }

        System.out.println(min);
    }

    static boolean checkOutOfBound(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }

    static boolean checkOtherIsland(int tx, int ty, int ox, int oy) {

        Queue<Coord> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        queue.offer(new Coord(tx, ty));
        visited[tx][ty] = true;

        while (!queue.isEmpty()) {

            Coord now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (checkOutOfBound(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if (nx == ox && ny == oy) {
                    return false;
                }

                if (arr[nx][ny] == 1) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return true;
    }

    static int solution(int x, int y) {

        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(x, y));
        int[][] visited = new int[N][N];
        visited[x][y] = 1;

        while (!queue.isEmpty()) {

            Coord now = queue.poll();

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (checkOutOfBound(nx, ny) || visited[nx][ny] != 0) {
                    continue;
                }

                if (arr[nx][ny] == 1 && checkOtherIsland(x, y, nx, ny)) {
                    return visited[now.x][now.y] - 1;
                }

                if (arr[nx][ny] == 0) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }

        return Integer.MAX_VALUE;
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