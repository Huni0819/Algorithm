import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Main {

    static int N;
    static int M;

    static int[] arr = new int[101];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for (int i = 1; i <= 100; i++) {

            arr[i] = i;
        }

        for (int i = 0; i < N + M; i++){

            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            arr[a] = b;
        }

        solution();
    }

    static void solution() {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        Integer[] visited = new Integer[101];
        visited[1] = 0;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == 100) {
                System.out.println(visited[now]);
                return;
            }

            for (int i = 1; i <= 6; i++) {

                int next = now + i;

                if (next > 100) {
                    continue;
                }

                if (arr[next] != next) {
                    next = arr[next];
                }

                if (Objects.isNull(visited[next])) {

                    visited[next] = visited[now] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}