import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] arr;
    static int[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int one = Integer.parseInt(st.nextToken());
        int two = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(reader.readLine());

        arr = new boolean[n+1][n+1];
        visited = new int[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arr[x][y] = true;
            arr[y][x] = true;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(one);
        visited[one] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == two) {
                System.out.println(visited[now]);
                System.exit(0);
            }

            for (int i = 0; i <= n; i++) {
                if (visited[i] == 0 && arr[now][i]) {
                    visited[i] = visited[now] + 1;
                    queue.offer(i);
                }
            }
        }

        System.out.println(-1);

        reader.close();
    }
}