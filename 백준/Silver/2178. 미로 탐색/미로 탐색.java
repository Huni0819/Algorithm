import java.io.*;
import java.util.*;

public class Main {

    static int[][] d = {
            { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }
    };

    static int N;
    static int M;

    static char[][] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = line.charAt(j);
            }
        }

        System.out.println(solution());
    }

    static int solution() {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));

        Integer[][] visited = new Integer[N][M];
        visited[0][0] = 1;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                break;
            }

            for (int i = 0; i < d.length; i++) {
                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (isOutOfBound(nx, ny) || Objects.nonNull(visited[nx][ny])) {
                    continue;
                }

                if (arr[nx][ny] == '1') {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                }
            }
        }

        return visited[N - 1][M - 1];
    }

    static boolean isOutOfBound(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
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