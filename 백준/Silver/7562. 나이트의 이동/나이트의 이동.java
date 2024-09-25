import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 2}, {2, 1}, {2, -1}, {1, -2},
            {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}
    };

    static int l;
    static int[][] arr;
    static Queue<Coord> queue = new LinkedList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int T = Integer.parseInt(reader.readLine());

        for (int tc = 0; tc < T; tc++) {
            queue.clear();

            l = Integer.parseInt(reader.readLine());

            arr = new int[l][l];

            String[] input = reader.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            arr[x][y] = 1; // 나이트의 현재 위치

            queue.offer(new Coord(x, y));

            input = reader.readLine().split(" ");
            arr[Integer.parseInt(input[0])][Integer.parseInt(input[1])] = -1; // 이동하려는 위치

            builder.append(solution())
                    .append("\n");
        }

        System.out.println(builder);
    }

    private static int solution() {
        while (!queue.isEmpty()) {
            Coord now = queue.poll();

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= l || ny < 0 || ny >= l || arr[nx][ny] >= 1) {
                    continue;
                }

                if (arr[nx][ny] == -1) {
                    return arr[now.x][now.y];
                }

                if (arr[nx][ny] == 0) {
                    queue.offer(new Coord(nx, ny));
                    arr[nx][ny] = arr[now.x][now.y] + 1;
                }
            }
        }

        return 0; // 시작 지점과 도착 지점이 같은 경우
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