import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    static int N;
    static int M;

    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {

            arr[i] = br.readLine().toCharArray();
        }

        int pW = 0;
        int pB = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {

                if (!visited[i][j]) {

                    int power = solution(i, j, arr[i][j]);

                    if (arr[i][j] == 'W') {
                        pW += power;
                    } else {
                        pB += power;
                    }
                }
            }
        }

        System.out.println(pW + " " + pB);
    }

    static int solution(int x, int y, char c) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        int count = 1;
        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] != c) {

                    continue;
                }

                queue.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                count++;
            }
        }

        return (int) Math.pow(count ,2);
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