import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine());

        System.out.println(solution(N));
    }

    static int solution(int n) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        int[] visited = new int[n+1];
        visited[n] = 1;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == 1) {
                return visited[now] - 1;
            }

            if (now % 3 == 0) {
                check(now, now/3, visited, queue);
            }

            if (now % 2 == 0) {
                check(now, now/2, visited, queue);
            }

            check(now, now-1, visited, queue);
        }

        return visited[1];
    }

    static void check(int now, int num, int[] visited, Queue<Integer> queue) {

        if (visited[num] == 0) {
            queue.offer(num);
            visited[num] = visited[now] + 1;
        }
    }

}