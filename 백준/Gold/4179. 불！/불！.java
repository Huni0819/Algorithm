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

    static char[][] arr;
    static int[][] jihoonVisited;
    static int[][] fireVisited;

    static Queue<Coordinate> fireQueue = new LinkedList<>();
    static Queue<Coordinate> jihoonQueue = new LinkedList<>();


    static Coordinate jihoonFirst;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        jihoonVisited = new int[n][m];
        fireVisited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'J') {
                    jihoonQueue.offer(new Coordinate(i, j));
                    jihoonVisited[i][j] = 1;
                    arr[i][j] = '.';
                    continue;
                } else if (line.charAt(j) == 'F') {
                    fireVisited[i][j] = 1;
                    fireQueue.offer(new Coordinate(i, j));
                }

                arr[i][j] = line.charAt(j);
            }
        }

        moveFire();
        moveJihoon();

        reader.close();
    }

    private static void moveFire() {

        while (!fireQueue.isEmpty()) {
            Coordinate now = fireQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    continue;
                }

                if (arr[nx][ny] != '#' && fireVisited[nx][ny] == 0) {
                    fireVisited[nx][ny] = fireVisited[now.getX()][now.getY()] + 1;
                    fireQueue.offer(new Coordinate(nx, ny));
                }
            }
        }
    }

    private static void moveJihoon() {

        while (!jihoonQueue.isEmpty()) {
            Coordinate now = jihoonQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    System.out.println(jihoonVisited[now.getX()][now.getY()]);
                    return;
                }

                if (arr[nx][ny] != '#' && jihoonVisited[nx][ny] == 0 && (fireVisited[nx][ny] > jihoonVisited[now.getX()][now.getY()] + 1 || fireVisited[nx][ny] == 0)) {
                    jihoonQueue.offer(new Coordinate(nx, ny));
                    jihoonVisited[nx][ny] = jihoonVisited[now.getX()][now.getY()] + 1;
                }
            }
        }

        System.out.println("IMPOSSIBLE");

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
