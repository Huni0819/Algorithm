import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int N;
    static int K;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        System.out.println(solution());
    }

    static int solution() {

        if (N == K) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        boolean[][] visited = new boolean[500_001][2];

        int time = 0;
        visited[N][time] = true;

        while (!queue.isEmpty()) {

            if (K > 500_000) {
                return -1;
            }

            if (visited[K][time % 2]) {
                return time;
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {

                int now = queue.poll();

                if (now - 1 >= 0 && !visited[now - 1][(time + 1) % 2]) {
                    visited[now - 1][(time + 1) % 2] = true;
                    queue.offer(now - 1);
                }

                if (now + 1 <= 500_000 && !visited[now + 1][(time + 1) % 2]) {
                    visited[now + 1][(time + 1) % 2] = true;
                    queue.offer(now + 1);
                }

                if (now * 2 <= 500_000 && !visited[now * 2][(time + 1) % 2]) {
                    visited[now * 2][(time + 1) % 2] = true;
                    queue.offer(now * 2);
                }
            }

            time++;
            K += time;

        }

        return -1;
    }
}