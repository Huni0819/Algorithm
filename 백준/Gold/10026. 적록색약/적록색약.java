import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int N;
    static char[][][] arr;
    static boolean[][] visited;
    static Queue<Coord> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder builder = new StringBuilder();

        N = Integer.parseInt(reader.readLine());
        arr = new char[2][N][N];

        for (int i = 0; i < N; i++) {
            String line = reader.readLine();

            for (int j = 0; j < N; j++) {

                arr[0][i][j] = line.charAt(j);
                arr[1][i][j] = line.charAt(j) == 'R' ? 'G' : line.charAt(j);
            }
        }

        builder.append(solution(arr[0]))
                .append(" ")
                .append(solution(arr[1]));

        System.out.println(builder);
    }

    private static int solution(char[][] arr) {
        visited = new boolean[N][N];
        queue = new LinkedList<>();

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (!visited[i][j]) {
                    visited[i][j] = true;
                    queue.offer(new Coord(i, j));
                    count++;
                    bfs(arr);
                }
            }
        }

        return count;
    }

    private static void bfs(char[][] arr) {

        while(!queue.isEmpty()) {

            Coord now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny]) {
                    continue;
                }

                if (arr[now.x][now.y] == arr[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Coord(nx, ny));
                }
            }
        }
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