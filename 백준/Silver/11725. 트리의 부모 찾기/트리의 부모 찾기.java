import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    static int N;
    static List<Integer>[] lists;

    static int[] parents;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        lists = new List[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {

            String[] input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            lists[a].add(b);
            lists[b].add(a);
        }

        solution(1);

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {

            sb.append(parents[i])
                    .append("\n");
        }

        System.out.println(sb);
    }

    static void solution(int root) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        boolean[] visited = new boolean[N + 1];
        visited[root] = true;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int next : lists[now]) {

                if (visited[next]) {
                    continue;
                }

                queue.offer(next);
                visited[next] = true;
                parents[next] = now;
            }
        }
    }
}