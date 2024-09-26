import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int M;
    static int N;
    static int K;

    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new int[N][M];
        visited = new boolean[N][M];

        for (int k = 0; k < K; k++) {

            input = reader.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            for (int i = x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    count++;
                    pq.offer(solution(i, j));
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        builder.append(count)
                .append("\n");

        while (!pq.isEmpty()) {
            builder.append(pq.poll())
                    .append(" ");
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

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    queue.offer(new Coord(nx, ny));
                    visited[nx][ny] = true;
                    count++;
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