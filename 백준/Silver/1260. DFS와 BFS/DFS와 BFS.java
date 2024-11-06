import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;
    static int V;

    static List<Integer>[] lists;

    static StringBuilder builder = new StringBuilder();

    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        V = Integer.parseInt(input[2]);

        lists = new List[N+1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            input = br.readLine().split(" ");

            int p1 = Integer.parseInt(input[0]);
            int p2 = Integer.parseInt(input[1]);

            lists[p1].add(p2);
            lists[p2].add(p1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(lists[i]);
        }

        // DFS
        visited = new boolean[N+1];
        dfs(V);

        builder.append("\n");
        Arrays.fill(visited, false);
        // BFS
        bfs(V);

        System.out.print(builder);
    }

    static void dfs(int V) {

        if (!visited[V]) {
            visited[V] = true;
            builder.append(V)
                .append(" ");
        }

        for (int n : lists[V]) {

            if (!visited[n]) {
                dfs(n);
            }
        }
    }

    static void bfs(int V) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(V);
        visited[V] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            builder.append(now)
                        .append(" ");

            for (int num : lists[now]) {
                if (!visited[num]) {
                    visited[num] = true;
                    queue.offer(num);
                }
            }
        }
    }
}