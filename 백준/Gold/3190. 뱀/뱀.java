import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static boolean[][] apple;
    static boolean[][] body;

    static Queue<Command> queue = new LinkedList<>();
    static Deque<Coord> snake = new ArrayDeque<>();

    // 상하좌우
    // 0, 2, 1, 3
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static int direct = 3;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine());
        apple = new boolean[n][n];
        body = new boolean[n][n];

        int k = Integer.parseInt(reader.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // 사과가 놓여져 있는 위치
            apple[x][y] = true;
        }

        int l = Integer.parseInt(reader.readLine());

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            queue.offer(new Command(Integer.parseInt(st.nextToken()), st.nextToken()));
        }

        snake.offer(new Coord(0, 0));
        int count = 1;
        while (true) {
            Coord now = snake.peekFirst();

            int nx = now.x + dx[direct];
            int ny = now.y + dy[direct];

            if (!checkBound(nx, ny) || body[nx][ny]) {
                break;
            }

            if (apple[nx][ny]) {
                apple[nx][ny] = false;
            } else {
                Coord tail = snake.pollLast();
                body[tail.x][tail.y] = false;
            }

            body[nx][ny] = true;
            snake.offerFirst(new Coord(nx, ny));

            count++;

            if (!queue.isEmpty()) {
                Command command = queue.peek();

                if (command.time < count) {
                    queue.poll();

                    if (command.c.equals("D")) {
                        direct--;
                    } else {
                        direct++;
                    }

                    if (direct < 0) {
                        direct = 3;
                    }

                    if (direct > 3) {
                        direct = 0;
                    }
                }
            }
        }

        System.out.println(count);
    }

    private static boolean checkBound (int x, int y) {
        return (x >= 0 && y >= 0 && x < n && y < n);
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

class Command {

    int time;
    String c;

    public Command(int time, String c) {
        this.time = time;
        this.c = c;
    }
}