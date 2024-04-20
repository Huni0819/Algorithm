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
    static int count = 0;
    static int number = 0;
    static int previous;
    static int[][] arr;
    static boolean[][] visited;
    static Queue<Coordinate> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    count++;
                }
            }
        }

        while (count > 0) {
            previous = count;
            number++;
            visited = new boolean[n][m];
            solution();
        }

        System.out.println(number);
        System.out.println(previous);

        reader.close();
    }

    private static void solution() {
        queue.offer(new Coordinate(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = now.getX() + dx[i];
                int nextY = now.getY() + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m || visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                if (arr[nextX][nextY] == 0) {
                    queue.offer(new Coordinate(nextX, nextY));
                } else {
                    count--;
                    arr[nextX][nextY] = 0;
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