import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n;
    static int m;
    static int[][] arr;
    static int[][] count;
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        if (n == 1 && m == 1) {
            System.out.println(1);
            System.exit(0);
        }

        arr = new int[n+1][m+1];
        count = new int[n+1][m+1];
        visited = new boolean[n+1][m+1][2];

        for (int i = 1; i <= n; i++) {
            String line = reader.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j-1)));
            }
        }

        System.out.println(solution(new Coordinate(1, 1, false)));

        reader.close();
    }

    private static int solution(Coordinate coordinate) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coordinate);

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int x = now.getX() + dx[i];
                int y = now.getY() + dy[i];

                if (x < 1 || x > n || y < 1 || y  > m) {
                    continue;
                }

                if (arr[x][y] == 1) {
                    if (!now.isCrash() && !visited[x][y][1]) {
                        visited[x][y][1] = true;
                        count[x][y] = count[now.getX()][now.getY()] + 1;
                        queue.offer(new Coordinate(x, y, true));
                    }
                }
                else {
                    if (!visited[x][y][now.isCrash() ? 1 : 0]) {
                        visited[x][y][now.isCrash() ? 1 : 0] = true;
                        count[x][y] = count[now.getX()][now.getY()] + 1;
                        queue.offer(new Coordinate(x, y, now.isCrash()));
                    }
                }

                if (x == n && y == m) {
                    return count[x][y] + 1;
                }
            }
        }

        return -1;
    }


}

class Coordinate {
    private int x;
    private int y;
    private boolean crash;

    public Coordinate(int x, int y, boolean crash) {
        this.x = x;
        this.y = y;
        this.crash = crash;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isCrash() {
        return crash;
    }
}