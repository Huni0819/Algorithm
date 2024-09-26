import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int N;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        N = Integer.parseInt(reader.readLine());

        arr = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();

            for (int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == '1' && !visited[i][j]) {
                    count++;
                    pq.offer(solution(i, j));
                }
            }
        }

        builder.append(count)
                .append("\n");

        while (!pq.isEmpty()) {
            builder.append(pq.poll())
                    .append("\n");
        }

        System.out.println(builder);
    }

    static int solution(int x, int y) {
        Queue<Coord> queue = new LinkedList<>();
        queue.offer(new Coord(x, y));
        visited[x][y] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == '1') {
                    count++;
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return count;
    }
}

class Coord {

    int x;
    int y;

    public Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}