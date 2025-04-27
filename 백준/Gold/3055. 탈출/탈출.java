import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class Main {

    static int[][] d = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    static int R;
    static int C;

    static char[][] arr;
    static Deque<Node> deque = new ArrayDeque<>();
    static Integer[][] visited;
    static int[] end;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);

        arr = new char[R][C];
        visited = new Integer[R][C];

        for (int i = 0; i < R; i++) {

            String line = br.readLine();
            for (int j = 0; j < C; j++) {

                arr[i][j] = line.charAt(j);

                if (arr[i][j] == '*') {
                    deque.offerFirst(new Node(i, j, true));
                    visited[i][j] = 0;
                } else if (arr[i][j] == 'S') {
                    deque.offerLast(new Node(i, j, false));
                    visited[i][j] = 0;
                    arr[i][j] = '.';
                } else if (arr[i][j] == 'D') {
                    end = new int[]{i, j};
                }
            }
        }

        solution();
        System.out.println(Objects.isNull(visited[end[0]][end[1]]) ? "KAKTUS" : visited[end[0]][end[1]]);
    }

    static void solution() {

        while (!deque.isEmpty()) {

            Node now = deque.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || Objects.nonNull(visited[nx][ny])) {
                    continue;
                }

                if (arr[nx][ny] == 'D' && !now.water) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    return;
                }

                if (arr[nx][ny] != '.') {
                    continue;
                }

                if (now.water) {

                    arr[nx][ny] = '*';
                }

                deque.offerLast(new Node(nx, ny, now.water));
                visited[nx][ny] = visited[now.x][now.y] + 1;
            }
        }
    }
}

class Node {

    int x;
    int y;
    boolean water;

    public Node(int x, int y, boolean water) {
        this.x = x;
        this.y = y;
        this.water = water;
    }
}