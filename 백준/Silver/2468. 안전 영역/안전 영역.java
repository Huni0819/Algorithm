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
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());

        arr = new int[N][N];

        int max = 1;
        int min = 100;

        for (int i = 0; i < N; i++) {
            String[] input = reader.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);

                max = Math.max(max, arr[i][j]);
                min = Math.min(min, arr[i][j]);
            }
        }

        int count = 1;
        for (int i = min; i <= max; i++) {
            count = Math.max(count, solution(i));
        }

        System.out.println(count);
    }

    static int solution(int height) {
        visited = new boolean[N][N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (arr[i][j] > height && !visited[i][j]) {
                    count++;
                    bfs(i, j, height);
                }
            }
        }

        return count;
    }

    static void bfs(int x, int y, int height) {
        Queue<Coord> queue = new LinkedList<>();
        visited[x][y] = true;

        queue.offer(new Coord(x, y));

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] > height) {
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