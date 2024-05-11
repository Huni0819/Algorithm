import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // d에 의해서 영향을 받는데
    // d = 0, 1, 2, 3 반시계 방향으로 회전함
    // 북 -> 서 -> 남 -> 동
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[][] visited;

    static int n;
    static int m;
    static int r;
    static int c;
    static int d;
    static int[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 방의 크기는 N x M
        // 첫 줄에 N과 M이 입력된다.
        StringTokenizer st = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 둘째 줄에 로봇 청소기의 위치 r, c와 로봇 청소기가 바라보는 방향 d가 입력된다.
        st = new StringTokenizer(reader.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // d = 0(북), 1(동), 2(남), 3(서)
        d = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m];
        // 셋째 줄부터 N개의 줄에 각 장소의 상태가 입력된다.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());

        reader.close();
    }

    /**
     * 로봇 청소기의 동작
     * 1. 현재 칸이 청소되지 않은 경우, 청소.
     *
     * 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
     *  1. 바라보는 방향을 유지한 채 한칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아감.
     *  2. 바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없으면 작동을 멈춘다.
     *
     * 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
     *  1. 반시계 방향으로 90도 회전한다.
     *  2. 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않았다면 한칸 전진 후 1번으로 돌아감.
     */
    private static int solution() {
        int count = 0;

        Queue<Coordinate> queue = new LinkedList<>();
        queue.offer(new Coordinate(r, c));

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();

            if (!visited[now.getX()][now.getY()]) {
                visited[now.getX()][now.getY()] = true;
                count++;
            }

            int check = 0;
            for (int i = 0; i < 4; i++) {
                int nx = now.getX() + dx[i];
                int ny = now.getY() + dy[i];

                if (arr[nx][ny] == 0 && !visited[nx][ny]) {
                    check++;
                }
            }

            // 주변 4칸에 청소할 수 있는 칸이 남아 있지 않다면
            if (check == 0) {
                // 뒷 칸이 벽이어서 진행이 안된다면 동작을 멈춤
                if (arr[now.getX() - dx[d]][now.getY() - dy[d]] == 1) {
                    break;
                } else {
                    // 뒤로 한칸 이동 후 이어서 진행한다.
                    queue.offer(new Coordinate(now.getX() - dx[d], now.getY() - dy[d]));
                }
            }
            // 주변 4칸에 청소해야 할 칸이 남아있다면
            else {
                //반 시계 방향으로 회전하며 청소할 칸을 찾는다.
                // 0 -> 3 -> 2 -> 1 -> 0
                while (true) {
                    d = d == 0 ? 3 : d - 1;

                    if (arr[now.getX() + dx[d]][now.getY() + dy[d]] == 0 && !visited[now.getX() + dx[d]][now.getY() + dy[d]]) {
                        queue.offer(new Coordinate(now.getX() + dx[d], now.getY() + dy[d]));
                        break;
                    }
                }
            }
        }

        return count;
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