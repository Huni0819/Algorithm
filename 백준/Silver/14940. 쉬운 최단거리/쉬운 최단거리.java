import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    static int n;
    static int m;

    static int[][] arr;
    static int[][] result;

    static Node start;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n][m];
        result = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(result[i], -1);
        }

        for (int i = 0; i < n; i++) {

            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);

                if (arr[i][j] == 0) {
                    result[i][j] = 0;
                } else if (arr[i][j] == 2) {
                    start = new Node(i, j);
                    result[i][j] = 0;
                }
            }
        }

        solution();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                sb.append(result[i][j])
                        .append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void solution() {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m || result[nx][ny] != -1 || arr[nx][ny] == 0) {
                    continue;
                }

                queue.offer(new Node(nx, ny));
                result[nx][ny] = result[now.x][now.y] + 1;
            }
        }
    }
}

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}