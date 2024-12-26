import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int V;
    static int E;

    static List<Node>[] lists;
    static Integer[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        V = Integer.parseInt(input[0]);
        E = Integer.parseInt(input[1]);
        int K = Integer.parseInt(br.readLine());

        lists = new List[V + 1];
        visited = new Integer[V + 1];

        for (int i = 1; i <= V; i++) {

            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {

            input = br.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            lists[u].add(new Node(v, w));
        }

        solution(K);

        StringBuilder builder = new StringBuilder();

        for (int i = 1; i <= V; i++) {
            builder.append(Objects.isNull(visited[i]) ? "INF" : visited[i])
            .append("\n");
        }

        System.out.print(builder);
    }

    static void solution(int K) {

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {

            public int compare(Node n1, Node n2) {
                return n1.w == n2.w ? n1.v - n2.v : n1.w - n2.w;
            }
        });

        visited[K] = 0;
        for (Node n : lists[K]) {
            queue.offer(n);
        }

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            if (Objects.nonNull(visited[now.v])) {
                continue;
            }

            visited[now.v] = now.w;

            for (Node next : lists[now.v]) {
                
                if (Objects.isNull(visited[next.v])) {
                    queue.offer(new Node(next.v, visited[now.v] + next.w));
                }
            }
        }
    }
}

class Node {

    int v;
    int w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

}