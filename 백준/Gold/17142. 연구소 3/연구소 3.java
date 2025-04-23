import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {-1, 0}, {0, -1}, {1, 0}, {0, 1}
    };

    static int N;
    static int M;

    static int[][] arr;
    static Node[] activations;
    static List<Node> virus = new ArrayList<>();
    static int space = 0;

    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N][N];
        activations = new Node[M];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {

                arr[i][j] = Integer.parseInt(input[j]);

                if (arr[i][j] == 0) {
                    space++;
                } else if (arr[i][j] == 2) {
                    virus.add(new Node(i, j, 0));
                }
            }
        }

        if (space == 0) {
            System.out.println(0);
            return;
        }

        solution(0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void solution(int idx, int dep) {

        if (dep == M) {
            bfs(space);
            return;
        }

        for (int i = idx; i < virus.size(); i++) {
            activations[dep] = virus.get(i);
            solution(i + 1, dep + 1);
        }
    }

    static void bfs(int space) {

        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];

        for (Node node : activations) {
            queue.offer(node);
            visited[node.x][node.y] = true;
        }

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || arr[nx][ny] == 1) {
                    continue;
                }

                if (arr[nx][ny] == 0) {
                    space--;
                }

                if (space == 0) {
                    min = Math.min(min, now.time + 1);
                    return;
                }

                queue.offer(new Node(nx, ny, now.time + 1));
                visited[nx][ny] = true;
            }
        }
    }
}

class Node {

    int x;
    int y;
    int time;

    public Node(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}