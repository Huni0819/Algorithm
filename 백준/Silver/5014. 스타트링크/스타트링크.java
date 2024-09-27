import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int F = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int G = Integer.parseInt(input[2]);
        int U = Integer.parseInt(input[3]);
        int D = Integer.parseInt(input[4]);

        int[] arr = new int[F+1];
        int[] visited = new int[F+1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        visited[S] = 1;

        while (!queue.isEmpty()){
            int now = queue.poll();

            if (now == G) {
                System.out.println(visited[now] - 1);
                return;
            }

            if (now + U <= F) {
                if (visited[now + U] == 0) {
                    queue.offer(now + U);
                    visited[now + U] = visited[now] + 1;
                }
            }

            if (now - D >= 1) {
                if (visited[now - D] == 0) {
                    queue.offer(now - D);
                    visited[now - D] = visited[now] + 1;
                }
            }
        }

        System.out.println("use the stairs");

    }
}