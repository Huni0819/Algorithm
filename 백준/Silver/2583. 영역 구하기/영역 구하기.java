import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int n;
    static int m;
    static int[][] arr;
    static boolean visited[][];
    static int count = 0;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int p = 0; p < k; p++) {
            st = new StringTokenizer(reader.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    count++;
                    list.add(solution(new Coordinate(i, j)));
                }
            }
        }

        Collections.sort(list);

        StringBuilder builder = new StringBuilder();
        builder.append(count).append("\n");
        list.forEach(num -> builder.append(num).append(" "));

        System.out.println(builder);

        reader.close();
    }

    private static int solution(Coordinate coordinate) {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(coordinate);
        visited[coordinate.getX()][coordinate.getY()] = true;
        int size = 0;

        while (!queue.isEmpty()) {
            size++;
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
                }
            }
        }

        return size;
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