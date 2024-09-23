import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

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
            String line = reader.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        solution();
    }

    private static void solution() {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0, 0, 1));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny]) {
                    continue;
                }

                if (nx == n-1 && ny == m-1) {
                    System.out.println(now.count+1);
                    System.exit(0);
                }

                if (arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Coord(nx, ny, now.count + 1));
                }
            }
        }
    }
}

class Coord {

    int x;
    int y;
    int count;

    public Coord(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}