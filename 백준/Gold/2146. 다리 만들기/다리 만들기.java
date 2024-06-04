import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int[][] arr;
    static int[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            // 0은 바다, 1은 육지
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // arr[i][j]가 1이어도 상하좌우가 다 육지면 스킵
                // 바다와 인접해 있는 경우만 검사.
                if (arr[i][j] == 1 && checkCoast(i, j)) {
                    min = Math.min(min, bfs(i, j));
                }
            }
        }

        System.out.println(min-1);
    }

    private static boolean checkCoast(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (checkOutOfBound(nx, ny)) {
                continue;
            }

            if (arr[nx][ny] == 0) {
                return true;
            }
        }

        return false;
    }

    private static boolean checkOutOfBound(int x, int y) {
        return x < 0 || x >= n || y < 0 || y >= n;
    }

    private static boolean checkAnotherIsland(Coord standard, Coord other) {
        boolean[][] visited = new boolean[n][n];

        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(standard.getX(), standard.getY()));
        visited[standard.getX()][standard.getY()] = true;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (checkOutOfBound(nx, ny)) {
                    continue;
                }

                if (nx == other.getX() && ny == other.getY()) {
                    return false;
                }

                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return true;
    }

    private static int bfs(int x, int y) {
        visited = new int[n][n];
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(x, y));
        visited[x][y] = 1;

        while(!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (checkOutOfBound(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny] == 0 && arr[nx][ny] == 0) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = visited[now.getX()][now.getY()] + 1;
                } else if (visited[nx][ny] == 0 && arr[nx][ny] == 1) {
                    if (checkAnotherIsland(new Coord(x, y), new Coord(nx, ny))) {
                        return visited[now.getX()][now.getY()];
                    }
                }

            }
        }

        return Integer.MAX_VALUE;
    }
}

class Coord {

    private int x;
    private int y;

    public Coord(int x, int y) {
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