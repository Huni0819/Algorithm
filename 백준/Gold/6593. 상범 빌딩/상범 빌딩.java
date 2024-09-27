import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0, 0},
            {-1, 0, 0},
            {0, 1, 0},
            {0, -1, 0},
            {0, 0, 1},
            {0 ,0, -1}
    };

    static int L;
    static int R;
    static int C;

    static char[][][] arr;
    static int[][][] visited;

    static Queue<Coord> queue = new LinkedList<>();

    static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] input = reader.readLine().split(" ");
            L = Integer.parseInt(input[0]);
            R = Integer.parseInt(input[1]);
            C = Integer.parseInt(input[2]);

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            queue.clear();

            arr = new char[L][R][C];
            visited = new int[L][R][C];

            for (int h = 0; h < L; h++) {

                for (int i = 0; i < R; i++) {
                    String line = reader.readLine();

                    for (int j = 0; j < C; j++) {
                        arr[h][i][j] = line.charAt(j);

                        if (arr[h][i][j] == 'S') {
                            queue.offer(new Coord(i, j, h));
                            visited[h][i][j] = 1;
                        }
                    }
                }

                reader.readLine();
            }

            solution();
        }

        System.out.println(builder);
    }

    static void solution() {

        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];
                int nz = now.z + d[i][2];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= R || ny >= C || nz >= L || visited[nz][nx][ny] != 0) {
                    continue;
                }

                if (arr[nz][nx][ny] == 'E') {
                    builder.append("Escaped in ")
                            .append(visited[now.z][now.x][now.y])
                            .append(" minute(s).")
                            .append("\n");
                    return;
                }

                if (arr[nz][nx][ny] == '.') {
                    visited[nz][nx][ny] = visited[now.z][now.x][now.y] + 1;
                    queue.offer(new Coord(nx, ny, nz));
                }
            }
        }

        builder.append("Trapped!")
                .append("\n");
    }
}

class Coord {

    int x;
    int y;
    int z;

    public Coord(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}