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
    static int[][] visited;
    static Queue<Coordinate> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'J') {
                    visited[i][j] = 1;
                    queue.offer(new Coordinate(i, j, true));
                    arr[i][j] = '.';
                    continue;
                }

                arr[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 'F') {
                    queue.offer(new Coordinate(i, j, false));
                }
            }
        }

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            if (now.isPerson() && arr[now.getX()][now.getY()] == 'F') {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                // queue에서 나온게 사람일 경우
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                    if (now.isPerson()) {
                        System.out.println(visited[now.getX()][now.getY()]);
                        System.exit(0);
                    }
                    // 불 일경우
                    continue;
                }


                if (now.isPerson()) {
                    if (arr[nx][ny] == '.' && visited[nx][ny] == 0) {
                        queue.offer(new Coordinate(nx, ny, true));
                        visited[nx][ny] = visited[now.getX()][now.getY()] + 1;
                    }
                } else {
                    if (arr[nx][ny] == '.') {
                        queue.offer(new Coordinate(nx, ny, false));
                        arr[nx][ny] = 'F';
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}

class Coordinate {

    private int x;
    private int y;
    private boolean isPerson;

    public Coordinate(int x, int y, boolean isPerson) {
        this.x = x;
        this.y = y;
        this.isPerson = isPerson;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPerson() {
        return isPerson;
    }
}