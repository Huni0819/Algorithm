import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};

    static int L;
    static int R;
    static int C;
    static char[][][] arr;
    static int[][][] visited;
    static Coordinate start;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            arr = new char[L][R][C];
            visited = new int[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = reader.readLine();
                    for (int k = 0; k < C; k++) {
                        if (line.charAt(k) == 'S') {
                            start = new Coordinate(i, j, k);
                            arr[i][j][k] = '.';
                        } else {
                            arr[i][j][k] = line.charAt(k);
                        }
                    }
                }
                reader.readLine();
            }

            int count = bfs();

            System.out.println(count == -1 ? "Trapped!" : "Escaped in " + count + " minute(s).");

        }

        reader.close();
    }

    private static int bfs() {
        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.getX()][start.getY()][start.getZ()] = 1;

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];
                int nz = now.getZ() + dz[i];

                if (nx < 0 || nx >= L || ny < 0 || ny >= R || nz < 0 || nz >= C) {
                    continue;
                }

                if (arr[nx][ny][nz] == 'E') {
                    return visited[now.getX()][now.getY()][now.getZ()];
                }

                if (arr[nx][ny][nz] == '.' && visited[nx][ny][nz] == 0) {
                    queue.offer(new Coordinate(nx, ny, nz));
                    visited[nx][ny][nz] = visited[now.getX()][now.getY()][now.getZ()] + 1;
                }
            }
        }

        return -1;
    }
}

class Coordinate {

    private int x;
    private int y;
    private int z;

    public Coordinate(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}