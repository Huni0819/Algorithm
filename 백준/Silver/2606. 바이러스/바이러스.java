import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {

    static int V;
    static int E;

    static List<Integer>[] list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());

        list = new List[V + 1];

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            int[] u = Stream.of(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            list[u[0]].add(u[1]);
            list[u[1]].add(u[0]);
        }

        System.out.print(solution());
    }

    static int solution() {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];

        int count = 0;
        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : list[now]) {

                if (visited[next]) {
                    continue;
                }

                queue.offer(next);
                visited[next] = true;
                count++;
            }
        }

        return count;
    }
}