import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int W;
    static int H;

    static char[][] arr;
    static int[][] visited;
    static Deque<Coord> deque = new ArrayDeque<>();

    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {
            deque.clear();

            String[] input = reader.readLine().split(" ");
            W = Integer.parseInt(input[0]);
            H = Integer.parseInt(input[1]);

            arr = new char[H][W];
            visited = new int[H][W];

            for (int i = 0; i < H; i++) {
                String line = reader.readLine();
                for (int j = 0; j < W; j++) {
                    arr[i][j] = line.charAt(j);

                    if (arr[i][j] == '@') {
                        arr[i][j] = '.';
                        deque.offerLast(new Coord(i, j, true));
                        visited[i][j] = 1;
                    } else if (arr[i][j] == '*') {
                        deque.offerFirst(new Coord(i, j, false));
                    }
                }
            }

            solution();
        }

        System.out.println(builder);
    }

    static void solution() {

        while (!deque.isEmpty()) {
            Coord now = deque.poll();

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= H || ny < 0 || ny >= W) {
                    if (now.isSang) {
                        builder.append(visited[now.x][now.y])
                                .append("\n");
                        return;
                    }

                    continue;
                }

                if (arr[nx][ny] == '.' && visited[nx][ny] == 0) {

                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    deque.offer(new Coord(nx, ny, now.isSang));
                }
            }
        }

        builder.append("IMPOSSIBLE")
                .append("\n");
    }
}

class Coord {

    int x;
    int y;
    boolean isSang;

    public Coord(int x, int y, boolean isSang) {
        this.x = x;
        this.y = y;
        this.isSang = isSang;
    }
}