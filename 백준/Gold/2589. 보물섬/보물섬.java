import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;

    static int[][] d = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        char[][] arr = new char[N][];

        for (int i = 0; i < N; i++) {

            arr[i] = br.readLine().toCharArray();
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                if (arr[i][j] == 'L') {
                    max = Math.max(max, solution(i, j, arr));
                }
            }
        }

        System.out.println(max);
    }

    static int solution(int x, int y, char[][] arr) {

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];

        queue.offer(new Node(x, y, 0));
        visited[x][y] = true;

        int max = 0;
        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (!checkBound(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if (arr[nx][ny] == 'L') {
                    queue.offer(new Node(nx, ny, now.count + 1));
                    visited[nx][ny] = true;
                    max = Math.max(max, now.count + 1);
                }
            }
        }

        return max;
    }

    static boolean checkBound(int x, int y) {

        return x >= 0 && x < N && y >= 0 && y < M;
    }
}

class Node {

    int x;
    int y;
    int count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}