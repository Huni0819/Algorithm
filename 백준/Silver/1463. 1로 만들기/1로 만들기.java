import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        if (n == 1) {
            System.out.println(0);
            System.exit(0);
        }

        visited = new int[n+1];

        solution(n);

        reader.close();
    }

    public static void solution(int num) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        visited[num] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = now;

                if (i == 0) {
                    if (next % 3 == 0) {
                        next /= 3;
                    } else {
                        continue;
                    }
                }

                if (i == 1) {
                    if (next % 2 == 0) {
                        next /= 2;
                    } else {
                        continue;
                    }
                }

                if (i == 2) {
                    next -= 1;
                }

                if (visited[next] == 0) {
                    if (next == 1) {
                        System.out.println(visited[now]);
                        return;
                    }

                    visited[next] = visited[now] + 1;
                    queue.offer(next);
                }


            }
        }

    }
}