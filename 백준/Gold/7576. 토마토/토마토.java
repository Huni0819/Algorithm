import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int n;
    static int m;

    static Queue<Coordinate> queue = new LinkedList<>();
    static int[][] arr;
    static int[][] count;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        count = new int[m][n];

        boolean flag = true;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    queue.offer(new Coordinate(i, j));
                } else if (arr[i][j] == 0) {
                    flag = false;
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

            for (int i = 0; i < 4; i++) {
                int nextX = now.getX() + dx[i];
                int nextY = now.getY() + dy[i];

                if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                    continue;
                }

                if (arr[nextX][nextY] == 0) {
                    arr[nextX][nextY] = 1;
                    count[nextX][nextY] = count[now.getX()][now.getY()] + 1;
                    queue.offer(new Coordinate(nextX, nextY));
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (arr[i][j] == 0) {
                    return -1;
                } else if (arr[i][j] == 1) {
                    max = Math.max(count[i][j], max);
                }
            }
        }

        return max;
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