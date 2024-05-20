import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static char[][][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(reader.readLine());
        arr = new char[N][N][2];

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j][0] = line.charAt(j);
                arr[i][j][1] = line.charAt(j) == 'G' ? 'R' : line.charAt(j);
            }
        }

        int count1 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, true);
                    count1++;
                }
            }
        }

        int count2 = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j, false);
                    count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);
        reader.close();
    }

    private static void bfs(int x, int y, boolean check) {
        int index = check ? 0 : 1;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (!visited[nx][ny] && arr[nx][ny][index] == arr[now.getX()][now.getY()][index]) {
                    queue.offer(new Coordinate(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}


class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}