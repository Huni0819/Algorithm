import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };

    static int w;
    static int h;

    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String[] input = br.readLine().split(" ");
            w = Integer.parseInt(input[0]);
            h = Integer.parseInt(input[1]);

            if (w == h && w == 0) {
                break;
            }

            arr = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {

                input = br.readLine().split(" ");

                for (int j = 0; j < w; j++) {

                    arr[i][j] = Integer.parseInt(input[j]);
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {

                for (int j = 0; j < w; j++) {

                    if (arr[i][j] == 1 && !visited[i][j]) {

                        solution(i, j);
                        count++;
                    }
                }
            }

            sb.append(count)
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void solution(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (!checkBound(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 1) {

                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
    }

    static boolean checkBound(int x, int y) {

        return x >= 0 && x < h && y >= 0 && y < w;
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