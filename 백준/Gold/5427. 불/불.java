import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static Deque<Coordinate> deque;

    static int[][] visited;
    static char[][] arr;
    static int w;
    static int h;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(reader.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            deque = new ArrayDeque<>();
            arr = new char[h][w];
            visited = new int[h][w];

            for (int i = 0; i < h; i++) {
                String line = reader.readLine();
                for (int j = 0; j < w; j++) {
                    arr[i][j] = line.charAt(j);

                    if (line.charAt(j) == '@') {
                        deque.offerFirst(new Coordinate(i, j, true));
                        visited[i][j] = 1;
                        arr[i][j] = '.';
                    } else if (line.charAt(j) == '*') {
                        deque.offerLast(new Coordinate(i, j, false));
                    }
                }
            }

            int count = solution();

            System.out.println(count == -1 ? "IMPOSSIBLE" : count);
        }

        reader.close();
    }

    private static int solution() {

        while (!deque.isEmpty()) {
            Coordinate now = deque.pollFirst();

            if (now.isPerson() && arr[now.getX()][now.getY()] == '*') {
                continue;
            }

            for(int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
                    if (now.isPerson()) {
                        return visited[now.getX()][now.getY()];
                    }
                    continue;
                }

                if (arr[nx][ny] == '#') {
                    continue;
                }

                if (now.isPerson() && arr[nx][ny] == '.' && visited[nx][ny] == 0) {
                    deque.offer(new Coordinate(nx, ny, true));
                    visited[nx][ny] = visited[now.getX()][now.getY()] + 1;
                } else if (!now.isPerson() && arr[nx][ny] == '.') {
                    deque.offerLast(new Coordinate(nx, ny, false));
                    arr[nx][ny] = '*';
                }
            }
        }

        return -1;
    }
}

class Coordinate {

    private int x;
    private int y;
    private boolean person;

    public Coordinate(int x, int y, boolean person) {
        this.x = x;
        this.y = y;
        this.person = person;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPerson() {
        return person;
    }

}