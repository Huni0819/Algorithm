import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int n;
    static int m;
    static int h;

    static Queue<Coordinate> queue = new LinkedList<>();
    static int[][][] arr;
    static int[][][] count;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[n][m][h];
        count = new int[n][m][h];

        boolean flag = true;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < m; j++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                    if (arr[i][j][k] == 1) {
                        queue.offer(new Coordinate(i, j, k));
                    } else if (arr[i][j][k] == 0) {
                        flag = false;
                    }
                }
            }
        }

        if (flag) {
            System.out.println(0);
            System.exit(0);
        }

        System.out.println(solution());

        reader.close();
    }

    private static int solution() {

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = now.getX() + dx[i];
                int nextY = now.getY() + dy[i];
                int nextZ = now.getZ() + dz[i];

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || nextZ < 0 || nextZ >= h) {
                    continue;
                }

                if (arr[nextX][nextY][nextZ] == 0) {
                    arr[nextX][nextY][nextZ] = 1;
                    count[nextX][nextY][nextZ] = count[now.getX()][now.getY()][now.getZ()] + 1;
                    queue.offer(new Coordinate(nextX, nextY, nextZ));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int k = 0; k < h; k++) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if (arr[i][j][k] == 0) {
                        return -1;
                    } else if (arr[i][j][k] == 1) {
                        max = Math.max(count[i][j][k], max);
                    }
                }
            }
        }

        return max;
    }
}

class Coordinate {
    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}