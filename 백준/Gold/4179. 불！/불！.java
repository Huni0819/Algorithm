import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static int[][] d = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    static int R;
    static int C;
    static char[][] arr;
    static int[][] visited;

    static Deque<Coord> deque = new ArrayDeque<>();


    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = new char[R][C];
        visited = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = reader.readLine();

            for (int j = 0; j < C; j++) {
                arr[i][j] = line.charAt(j);

                if (arr[i][j] == 'J') {
                    arr[i][j] = '.';
                    deque.offerLast(new Coord(i, j, true));
                    visited[i][j] = 1;
                } else if (arr[i][j] == 'F') {
                    deque.offerFirst(new Coord(i, j, false));
                    visited[i][j] = 1;
                }
            }
        }

        solution();
    }

    private static void solution() {

        while (!deque.isEmpty()) {
            Coord now = deque.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {

                    if (now.isJihoon) {
                        System.out.println(visited[now.x][now.y]);
                        System.exit(0);
                    }

                    continue;
                }

                if (arr[nx][ny] == '.' && visited[nx][ny] == 0) {
                    deque.offerLast(new Coord(nx, ny, now.isJihoon));
                    visited[nx][ny] = visited[now.x][now.y] + 1;

                    if (!now.isJihoon) {
                        arr[nx][ny] = 'F';
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}

class Coord {

    int x;
    int y;
    boolean isJihoon;

    public Coord(int x, int y, boolean isJihoon) {
        this.x = x;
        this.y = y;
        this.isJihoon = isJihoon;
    }
}