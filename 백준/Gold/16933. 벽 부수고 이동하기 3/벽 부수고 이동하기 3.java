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
    static boolean[][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][k+1];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
            }
        }

        solution();
    }

    private static void solution() {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(0, 0, k, true, 1));
        visited[0][0][k] = true;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            if (now.getX() == n-1 && now.getY() == m-1) {
                System.out.println(now.getDay());
                return;
            }

            for (int i = 0; i < 4; i++) {
                 int nx = now.getX() + dx[i];
                 int ny = now.getY() + dy[i];

                 if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                     continue;
                 }

                 if (now.isDay() && now.getCount() > 0 && arr[nx][ny] == 1 && !visited[nx][ny][now.getCount() - 1]) {
                     queue.offer(new Coord(nx, ny, now.getCount()-1, !now.isDay(), now.getDay()+1));
                     visited[nx][ny][now.getCount()-1] = true;
                 } else if (arr[nx][ny] == 0 && !visited[nx][ny][now.getCount()]) {
                     queue.offer(new Coord(nx, ny, now.getCount(), !now.isDay(), now.getDay()+1));
                     visited[nx][ny][now.getCount()] = true;
                 } else if (!now.isDay() && now.getCount() > 0 && arr[nx][ny] == 1 && !visited[nx][ny][now.getCount() - 1]) {
                     queue.offer(new Coord(now.getX(), now.getY(), now.getCount(), !now.isDay(), now.getDay()+1));
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
    private boolean isDay;
    private int day;

    public Coord(int x, int y, int count, boolean isDay, int day) {
        this.x = x;
        this.y = y;
        this.count = count;
        this.isDay = isDay;
        this.day = day;
    }

    public int getDay() {
        return day;
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

    public boolean isDay() {
        return isDay;
    }
}