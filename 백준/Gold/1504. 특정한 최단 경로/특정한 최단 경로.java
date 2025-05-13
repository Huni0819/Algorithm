import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int E;

    static List<Node>[] lists;
    static int v1;
    static int v2;

    static final int INF = 200_000_000;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);

        lists = new List[N + 1];

        for (int i = 1; i <= N; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            lists[a].add(new Node(b, c));
            lists[b].add(new Node(a, c));
        }

        input = br.readLine().split(" ");
        v1 = Integer.parseInt(input[0]);
        v2 = Integer.parseInt(input[1]);

        int result1 = solution(1, v1) + solution(v1, v2) + solution(v2, N);
        int result2 = solution(1, v2) + solution(v2, v1) + solution(v1, N);

        System.out.println(result1 >= INF && result2 >= INF ? -1 : Math.min(result1, result2));
    }

    static int solution(int s, int e) {

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o -> o.w));
        boolean[] visited = new boolean[N + 1];
        int[] d = new int[N + 1];
        Arrays.fill(d, INF);

        queue.offer(new Node(s, 0));
        d[s] = 0;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (visited[now.x]) {
                continue;
            }

            visited[now.x] = true;

            for (Node next : lists[now.x]) {

                if (visited[next.x] || d[next.x] <= d[now.x] + next.w) {
                    continue;
                }

                d[next.x] = d[now.x] + next.w;
                queue.offer(new Node(next.x, d[next.x]));
            }
        }

        return d[e];
    }
}

class Node {

    int x;
    int w;

    public Node(int x, int w) {
        this.x = x;
        this.w = w;
    }
}