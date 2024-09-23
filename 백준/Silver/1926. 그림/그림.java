import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Coord[] dCoord = {
            new Coord(1, 0),
            new Coord(-1, 0),
            new Coord(0, 1),
            new Coord(0, -1)
    };

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            input = reader.readLine().split(" ");

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int max = 0;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 1 && !visited[i][j]) {
                    count++;
                    max = Math.max(max, solution(i, j));
                }
            }
        }

        System.out.println(count);
        System.out.println(max);

    }

    private static int solution(int x, int y) {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(x, y));
        visited[x][y] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dCoord[i].x;
                int ny = now.y + dCoord[i].y;

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (arr[nx][ny] == 1 && !visited[nx][ny]) {
                    count++;
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
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