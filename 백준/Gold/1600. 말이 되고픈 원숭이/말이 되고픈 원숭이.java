import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dxHorse = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dyHorse = {2, 1, -1, -2, -2, -1, 1, 2};

    static int[] dxMonkey = {-1, 1, 0, 0};
    static int[] dyMonkey = {0, 0, -1, 1};

    static int k;
    static int w;
    static int h;

    static int[][] arr;
    static int[][][] visited;

    static Queue<Coord> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[h][w];
        visited = new int[h][w][k+1];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();
    }

    static void solution() {
        queue.offer(new Coord(0, 0, k));
        visited[0][0][k] = 1;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            if (now.getX() == h-1 && now.getY() == w-1) {
                System.out.println(visited[now.getX()][now.getY()][now.getCount()] - 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dxMonkey[i];
                int ny = now.getY() + dyMonkey[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    continue;
                }

                if (arr[nx][ny] == 0 && visited[nx][ny][now.getCount()] == 0) {
                    queue.offer(new Coord(nx, ny, now.getCount()));
                    visited[nx][ny][now.getCount()] = visited[now.getX()][now.getY()][now.getCount()] + 1;
                }
            }

            if (now.getCount() > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now.getX() + dxHorse[i];
                    int ny = now.getY() + dyHorse[i];

                    if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                        continue;
                    }

                    if (arr[nx][ny] == 0 && visited[nx][ny][now.getCount()-1] == 0) {
                        queue.offer(new Coord(nx, ny, now.getCount() - 1));
                        visited[nx][ny][now.getCount()-1] = visited[now.getX()][now.getY()][now.getCount()] + 1;
                    }
                }
            }

        }

        System.out.println(-1);
    }

}

class Coord {

    private int x;
    private int y;
    private int count;

    public Coord(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getCount() {
        return count;
    }
}