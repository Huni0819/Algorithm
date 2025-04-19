import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int M;

    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {

            String line = br.readLine();
            for (int j = 0; j < M; j++) {

                arr[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (visited[i][j]) {
                    continue;
                }

                solution(i, j, arr[i][j] == '-');
                count++;
            }
        }

        System.out.println(count);
    }

    static void solution(int x, int y, boolean flag) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));

        visited[x][y] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            int nx = flag ? now.x : now.x + 1;
            int ny = flag ? now.y + 1 : now.y;

            if (nx >= N || ny >= M || visited[nx][ny] || arr[now.x][now.y] != arr[nx][ny]) {
                continue;
            }

            queue.offer(new Node(nx, ny));
            visited[nx][ny] = true;
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