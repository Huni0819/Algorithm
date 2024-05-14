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
    static int k;

    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(reader.readLine());


        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[n][m];
            visited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(reader.readLine());

                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            int count = 0;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    if (arr[j][l] == 1 && !visited[j][l]) {
                        bfs(j, l);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
        reader.close();
    }

    private static void bfs(int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Coordinate(nx, ny));
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