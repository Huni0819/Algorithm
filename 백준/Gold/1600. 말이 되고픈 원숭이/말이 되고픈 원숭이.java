import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] horse = {
            {1, 2}, {2, 1}, {2, -1}, {1, -2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int K;
    static int W;
    static int H;

    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(reader.readLine());

        String[] input = reader.readLine().split(" ");
        W = Integer.parseInt(input[0]);
        H = Integer.parseInt(input[1]);

        arr = new int[H][W];

        for (int i = 0; i < H; i++) {
            input = reader.readLine().split(" ");

            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        Queue<Monkey> queue = new LinkedList<>();
        queue.offer(new Monkey(0, 0, K));

        int[][][] visited = new int[H][W][K+1];

        visited[0][0][K] = 1;

        while (!queue.isEmpty()) {

            Monkey now = queue.poll();

            if (now.x == H-1 && now.y == W-1) {
                return visited[now.x][now.y][now.horse] - 1;
            }

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                move(queue, now, nx, ny, now.horse, visited);
            }

            if (now.horse > 0) {
                for (int i = 0; i < horse.length; i++) {

                    int nx = now.x + horse[i][0];
                    int ny = now.y + horse[i][1];

                    move(queue, now, nx, ny, now.horse-1, visited);
                }
            }
        }

        return -1;
    }

    static boolean checkOutOfBound(int x, int y) {
        return x < 0 || x >= H || y < 0 || y >= W;
    }

    static void move(Queue<Monkey> queue, Monkey now, int nx, int ny, int horse, int[][][] visited) {
        if (checkOutOfBound(nx, ny) || visited[nx][ny][horse] != 0) {
            return;
        }

        if (arr[nx][ny] == 0) {
            queue.offer(new Monkey(nx, ny, horse));
            visited[nx][ny][horse] = visited[now.x][now.y][now.horse] + 1;
        }
    }
}

class Monkey {

    int x;
    int y;
    int horse;

    public Monkey(int x, int y, int horse) {
        this.x = x;
        this.y = y;
        this.horse = horse;
    }
}