import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int[][] d = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}
    };

    static int N;
    static int R;
    static int L;

    static int[][] arr;
    static boolean[][] visited;
    static List<Node> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);

        arr = new int[N][N];

        for (int i = 0; i < N; i++) {

            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {

                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        int day = 0;

        while (true) {

            boolean flag = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {

                    if (visited[i][j]) {
                        continue;
                    }

                    list.clear();

                    int sum = solution(i, j);

                    if (list.size() > 1) {
                        flag = true;
                        move(sum);
                    }
                }
            }

            if (!flag) {
                break;
            }

            day++;
        }

        System.out.println(day);
    }

    static int solution(int x, int y) {

        Queue<Node> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Node(x, y));

        int sum = arr[x][y];
        list.add(new Node(x, y));

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < d.length; i++) {

                int nx = now.x + d[i][0];
                int ny = now.y + d[i][1];

                if (!checkBound(nx, ny) || visited[nx][ny]) {
                    continue;
                }

                int sub = Math.abs(arr[now.x][now.y] - arr[nx][ny]);

                if (sub >= L && sub <= R) {
                    Node next = new Node(nx, ny);
                    queue.offer(next);
                    list.add(next);
                    sum += arr[nx][ny];
                    visited[nx][ny] = true;
                }
            }
        }

        return sum;
    }

    static boolean checkBound(int x, int y) {

        return x >= 0 && x < N && y >= 0 && y < N;
    }

    static void move(int sum) {

        int avg = sum / list.size();

        for (Node n : list) {

            arr[n.x][n.y] = avg;
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