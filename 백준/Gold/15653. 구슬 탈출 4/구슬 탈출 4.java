import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N;
    static int M;
    static char[][] arr;

    static int[][][][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        visited = new int[N][M][N][M];

        Point init = new Point();
        for (int i = 0; i < N; i++) {
            String line = reader.readLine();

            for (int j = 0; j < M; j++) {

                arr[i][j] = line.charAt(j);
                if (line.charAt(j) == 'R') {
                    init.rx = i;
                    init.ry = j;

                    arr[i][j] = '.';
                }

                if (line.charAt(j) == 'B') {
                    init.bx = i;
                    init.by = j;

                    arr[i][j] = '.';
                }
            }
        }

        System.out.println(solution(init));
    }

    private static int solution(Point init) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(init);
        visited[init.rx][init.ry][init.bx][init.by] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 4; i++) {

                int rx = now.rx;
                int ry = now.ry;
                int bx = now.bx;
                int by = now.by;

                boolean isR = false;
                boolean isB = false;

                while (true) {

                    rx += dx[i];
                    ry += dy[i];

                    if (checkBound(rx, ry)) {
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }

                    if (arr[rx][ry] == '#') {
                        rx -= dx[i];
                        ry -= dy[i];
                        break;
                    }

                    if (arr[rx][ry] == 'O') {
                        isR = true;
                        break;
                    }
                }

                while (true) {

                    bx += dx[i];
                    by += dy[i];

                    if (checkBound(bx, by)) {
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }

                    if (arr[bx][by] == '#') {
                        bx -= dx[i];
                        by -= dy[i];
                        break;
                    }

                    if (arr[bx][by] == 'O') {
                        isB = true;
                        break;
                    }
                }

                if (isB) {
                    continue;
                }

                if (isR) {
                    return visited[now.rx][now.ry][now.bx][now.by];
                }

                if (rx == bx && ry == by) {

                    switch (i) {
                        // 0 -> {-1, 0} | 1 -> {1, 0} | 2 -> {0, -1} | 3 -> {0, 1}
                        case 0:
                            if (now.rx > now.bx) {
                                rx -= dx[i];
                            } else {
                                bx -= dx[i];
                            }
                            break;
                        case 1:
                            if (now.rx > now.bx) {
                                bx -= dx[i];
                            } else {
                                rx -= dx[i];
                            }
                            break;
                        case 2:
                            if (now.ry > now.by) {
                                ry -= dy[i];
                            } else {
                                by -= dy[i];
                            }
                            break;
                        case 3:
                            if (now.ry > now.by) {
                                by -= dy[i];
                            } else {
                                ry -= dy[i];
                            }
                            break;
                    }
                }

                if (visited[rx][ry][bx][by] == 0) {
                    visited[rx][ry][bx][by] = visited[now.rx][now.ry][now.bx][now.by] + 1;
                    queue.offer(new Point(rx, ry, bx, by));
                }
            }
        }

        return -1;
    }

    private static boolean checkBound(int x, int y) {
        return x < 0 || y < 0 || x >= N || y >= M;
    }


}


class Point {

    int rx;
    int ry;
    int bx;
    int by;

    public Point() {
    }

    public Point(int rx, int ry, int bx, int by) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
    }
}