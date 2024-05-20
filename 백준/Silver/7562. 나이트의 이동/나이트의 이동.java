import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    static int N;
    static int[][] board;
    static Coordinate target;
    static Queue<Coordinate> queue;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {

            N = Integer.parseInt(reader.readLine());
            board = new int[N][N];

            StringTokenizer st = new StringTokenizer(reader.readLine());
            Coordinate start = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            board[start.getX()][start.getY()] = 1;
            queue = new LinkedList<>();
            queue.offer(start);

            st = new StringTokenizer(reader.readLine());
            target = new Coordinate(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (start.getX() == target.getX() && start.getY() == target.getY()) {
                System.out.println(0);
                continue;
            }

            bfs();
        }

        reader.close();
    }

    private static void bfs() {

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
                    continue;
                }

                if (nx == target.getX() && ny == target.getY()) {
                    System.out.println(board[now.getX()][now.getY()]);
                    return;
                }

                if (board[nx][ny] == 0) {
                    board[nx][ny] = board[now.getX()][now.getY()] + 1;
                    queue.offer(new Coordinate(nx, ny));
                }
            }
        }
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