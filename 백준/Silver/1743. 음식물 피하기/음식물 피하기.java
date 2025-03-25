import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int N;
    static int M;
    static int K;

    static boolean[][] visited;
    static boolean[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);

        arr = new boolean[N + 1][M + 1];
        visited = new boolean[N + 1][M + 1];

        for (int i = 0; i < K; i++) {

            input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            arr[r][c] = true;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= M; j++) {

                if (arr[i][j] && !visited[i][j]) {

                    max = Math.max(max, solution(i, j));
                }
            }
        }

        System.out.println(max);
    }

    static int solution(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        int count = 1;

        while(!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (!checkBound(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                if(arr[nx][ny]) {

                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    count++;
                }
            }
        }

        return count;
    }

    static boolean checkBound(int x, int y) {

        return x >= 1 && x <= N && y >= 1 && y <= M;
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