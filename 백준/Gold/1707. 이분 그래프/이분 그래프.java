import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        String[] input;
        for (int tc = 0; tc < K; tc++) {

            input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]);
            int E = Integer.parseInt(input[1]);

            List<Integer>[] lists = new List[V + 1];

            for (int i = 1; i <= V; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                input = br.readLine().split(" ");
                int u = Integer.parseInt(input[0]);
                int v = Integer.parseInt(input[1]);

                lists[u].add(v);
                lists[v].add(u);
            }

            builder.append(solution(V, E, lists) ? "YES" : "NO")
                    .append("\n");
        }

        System.out.println(builder);
    }

    static boolean solution(int V, int E, List<Integer>[] lists) {

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[V + 1];

        for (int i = 1; i <= V; i++) {

            if (visited[i] == 0) {
                queue.offer(i);
                visited[i] = 1;
            }

            while (!queue.isEmpty()) {

                int now = queue.poll();

                for (int next : lists[now]) {

                    if (visited[next] == visited[now]) {
                        return false;
                    }

                    if (visited[next] == 0) {
                        queue.offer(next);

                        visited[next] = visited[now] == 1 ? 2 : 1;
                    }
                }
            }
        }

        return true;
    }
}