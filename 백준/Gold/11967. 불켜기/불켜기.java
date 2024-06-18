import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;

    static boolean[][] arr;
    static boolean[][] visited;

    static Map<Coord, List<Coord>> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new boolean[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            // (x, y) 에서 (a, b) 방의 불을 켤 수 있음.
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Coord coord = new Coord(x, y);

            if (map.containsKey(coord)) {
                List<Coord> coords = map.get(coord);

                coords.add(new Coord(a, b));
            } else {
                List<Coord> coords = new ArrayList<>();

                coords.add(new Coord(a, b));

                map.put(coord, coords);
            }
        }

        solution(1, 1);
    }

    private static boolean check(int x, int y) {
        Queue<Coord> queue = new LinkedList<>();
        boolean visit[][] = new boolean[n+1][n+1];

        queue.offer(new Coord(1, 1));
        visit[1][1] = true;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            if (now.x == x && now.y == y) {
                return true;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || nx >= n+1 || ny < 1 || ny >= n+1 || !arr[nx][ny]) {
                    continue;
                }

                if (!visit[nx][ny]) {
                    queue.offer(new Coord(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }

        return false;
    }

    private static void solution(int x, int y) {
        Queue<Coord> queue = new LinkedList<>();
        arr[x][y] = true;
        queue.offer(new Coord(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            List<Coord> coords = map.get(now);

            if (!Objects.isNull(coords)) {
                for (Coord coord : coords) {
                    arr[coord.x][coord.y] = true;

                    if (!visited[coord.x][coord.y] && check(coord.x, coord.y)) {
                        queue.offer(new Coord(coord.x, coord.y));
                        visited[coord.x][coord.y] = true;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {

                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 1 || nx >= n + 1 || ny < 1 || ny >= n + 1) {
                    continue;
                }

                if (arr[nx][ny] && !visited[nx][ny]) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}

class Coord {

    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return x == coord.x && y == coord.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}