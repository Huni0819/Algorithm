import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Integer[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println(solution(n, k));

    }

    private static int solution(int n, int k) {
        if (n == k) {
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);

        boolean[][] visited = new boolean[500_001][2];
        int time = 0;
        visited[n][time] = true;

        while (!queue.isEmpty()) {
            if (k > 500_000) {
                return -1;
            }

            int newT = time % 2;

            if (visited[k][newT]) {
                return time;
            }

            for (int j = 0, size = queue.size(); j < size; j++) {
                int now = queue.poll();

                int nexT = (time + 1) % 2;
                int next;

                next = now - 1;

                if (next >= 0 && !visited[next][nexT]) {
                    visited[next][nexT] = true;
                    queue.offer(next);
                }

                next = now + 1;
                if (next < 500_001 && !visited[next][nexT]) {
                    visited[next][nexT] = true;
                    queue.offer(next);
                }

                next = now * 2;
                if (next < 500_001 && !visited[next][nexT]) {
                    visited[next][nexT] = true;
                    queue.offer(next);
                }
            }

            time++;
            k += time;
        }

        return -1;
    }
}